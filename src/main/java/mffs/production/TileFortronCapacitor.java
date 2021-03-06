package mffs.production

import java.util.{HashSet => JHashSet, Set => JSet}

import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.netty.buffer.ByteBuf
import mffs.Content
import mffs.base.{TileModuleAcceptor, TilePacketType}
import mffs.item.card.ItemCardFrequency
import mffs.util.TransferMode.TransferMode
import mffs.util.{FortronUtility, TransferMode}
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fluids.IFluidContainerItem

import scala.collection.JavaConversions._

class TileFortronCapacitor extends TileModuleAcceptor with IFortronStorage with IFortronCapacitor
{
  private val tickRate = 10
  private var transferMode = TransferMode.equalize

  capacityBase = 700
  capacityBoost = 10
  startModuleIndex = 1

  override def getSizeInventory = 3 + 4 * 2 + 1

  override def update()
  {
    super.update()
    this.consumeCost()

    if (isActive)
    {
      /**
       * Draw from input slots and eject from output slots
       */
      getInputStacks filter (_.getItem.isInstanceOf[IFluidContainerItem]) foreach (stack => fortronTank.fill(stack.getItem.asInstanceOf[IFluidContainerItem].drain(stack, Math.min(getFortronEmpty, getTransmissionRate), true), true))

      if (fortronTank.getFluidAmount > 0)
      {
        val transferFluid = fortronTank.getFluid.copy()
        transferFluid.amount = Math.min(transferFluid.amount, getTransmissionRate)
        getOutputStacks filter (_.getItem.isInstanceOf[IFluidContainerItem]) foreach (stack => fortronTank.drain(stack.getItem.asInstanceOf[IFluidContainerItem].fill(stack, transferFluid, true), true))
      }

      if (ticks % tickRate == 0)
      {
        /**
         * Transfer based on input/output slots
         */
        FortronUtility.transferFortron(this, getInputDevices, TransferMode.fill, getTransmissionRate * tickRate)
        FortronUtility.transferFortron(this, getOutputDevices, TransferMode.drain, getTransmissionRate * tickRate)

        /**
         * Transfer based on frequency
         */
        FortronUtility.transferFortron(this, getFrequencyDevices, transferMode, getTransmissionRate * tickRate)
      }
    }
  }

  def getTransmissionRate: Int = 300 + 60 * getModuleCount(Content.moduleSpeed)

  override def getAmplifier: Float = 0f

  /**
   * Packet Methods
   */

  override def write(buf: ByteBuf, id: Int)
  {
    super.write(buf, id)

    if (id == TilePacketType.description.id)
    {
      buf <<< transferMode.id
    }
  }

  override def read(buf: ByteBuf, id: Int, packetType: PacketType)
  {
    super.read(buf, id, packetType)

    if (id == TilePacketType.description.id)
    {
      transferMode = TransferMode(buf.readInt)
    }
    else if (id == TilePacketType.toggleMoe.id)
    {
      transferMode = transferMode.toggle
    }
  }

  override def readFromNBT(nbt: NBTTagCompound)
  {
    super.readFromNBT(nbt)
    this.transferMode = TransferMode(nbt.getInteger("transferMode"))
  }

  override def writeToNBT(nbttagcompound: NBTTagCompound)
  {
    super.writeToNBT(nbttagcompound)
    nbttagcompound.setInteger("transferMode", this.transferMode.id)
  }

  def getDeviceCount = getFrequencyDevices.size + getInputDevices.size + getOutputDevices.size

  override def getFrequencyDevices: JSet[IFortronFrequency] = FrequencyGridRegistry.instance.getNodes(classOf[IFortronFrequency], world, toVector3, getTransmissionRange, getFrequency)

  def getTransmissionRange: Int = 15 + getModuleCount(Content.moduleScale)

  def getInputDevices: JSet[IFortronFrequency] = getDevicesFromStacks(getInputStacks)

  def getInputStacks: Set[ItemStack] = ((4 to 7) map (i => getStackInSlot(i)) filter (_ != null)).toSet

  def getDevicesFromStacks(stacks: Set[ItemStack]): JSet[IFortronFrequency] =
  {
    val devices = new JHashSet[IFortronFrequency]()

    stacks
            .filter(_.getItem.isInstanceOf[ICoordLink])
            .map(itemStack => itemStack.getItem.asInstanceOf[ICoordLink].getLink(itemStack))
            .filter(linkPosition => linkPosition != null && linkPosition.getTileEntity(world).isInstanceOf[IFortronFrequency])
            .foreach(linkPosition => devices.add(linkPosition.getTileEntity(world).asInstanceOf[IFortronFrequency]))

    return devices
  }

  def getOutputDevices: JSet[IFortronFrequency] = getDevicesFromStacks(getOutputStacks)

  def getOutputStacks: Set[ItemStack] = ((8 to 11) map (i => getStackInSlot(i)) filter (_ != null)).toSet

  override def isItemValidForSlot(slotID: Int, itemStack: ItemStack): Boolean =
  {
    if (slotID == 0)
    {
      return itemStack.getItem.isInstanceOf[ItemCardFrequency]
    }
    else if (slotID < 4)
    {
      return itemStack.getItem.isInstanceOf[IModule]
    }

    return true
  }

  def getTransferMode: TransferMode = transferMode

  @SideOnly(Side.CLIENT)
  override def renderStatic(renderer: RenderBlocks, pos: Vector3, pass: Int): Boolean =
  {
    return false
  }

  @SideOnly(Side.CLIENT)
  override def renderDynamic(pos: Vector3, frame: Float, pass: Int)
  {
    RenderFortronCapacitor.render(this, pos.x, pos.y, pos.z, frame, isActive, false)
  }

  @SideOnly(Side.CLIENT)
  override def renderInventory(itemStack: ItemStack)
  {
    RenderFortronCapacitor.render(this, -0.5, -0.5, -0.5, 0, true, true)
  }
}