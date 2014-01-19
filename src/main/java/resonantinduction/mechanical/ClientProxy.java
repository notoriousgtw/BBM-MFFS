package resonantinduction.mechanical;

import net.minecraftforge.client.MinecraftForgeClient;
import resonantinduction.core.render.RenderRIItem;
import resonantinduction.mechanical.fluid.pipe.ItemPipeRenderer;
import resonantinduction.mechanical.fluid.tank.ItemTankRenderer;
import resonantinduction.mechanical.fluid.tank.RenderTank;
import resonantinduction.mechanical.fluid.tank.TileTank;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		MinecraftForgeClient.registerItemRenderer(Mechanical.itemGear.itemID, RenderRIItem.INSTANCE);
	}

	@Override
	public void init()
	{
		MinecraftForgeClient.registerItemRenderer(Mechanical.blockTank.blockID, new ItemTankRenderer());
		MinecraftForgeClient.registerItemRenderer(Mechanical.itemPipe.itemID, new ItemPipeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileTank.class, RenderTank.INSTANCE);
	}
}