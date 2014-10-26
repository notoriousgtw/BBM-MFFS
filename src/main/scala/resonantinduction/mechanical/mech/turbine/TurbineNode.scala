package resonantinduction.mechanical.mech.turbine

import net.minecraftforge.common.util.ForgeDirection
import resonantinduction.mechanical.mech.MechanicalNode

/**
 * Turbine's Mechanical node
 * Turbines always face forward and connect from behind.
 *
 * @author Calclavia, Darkguardsman
 */
class TurbineNode(tileTurbineBase: TileTurbine) extends MechanicalNode(tileTurbineBase)
{

  def turbine: TileTurbine =
  {
    return getParent.asInstanceOf[TileTurbine]
  }

  override def canConnect(source: AnyRef, from: ForgeDirection): Boolean =
  {
    return turbine.getMultiBlock.isPrimary && source.isInstanceOf[MechanicalNode] && !(source.isInstanceOf[TurbineNode]) && from == turbine.getDirection
  }

  override def inverseRotation(dir: ForgeDirection): Boolean =
  {
    return dir == turbine.getDirection.getOpposite
  }
}