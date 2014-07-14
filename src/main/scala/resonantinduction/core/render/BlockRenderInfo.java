package resonantinduction.core.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import universalelectricity.core.transform.vector.Vector3;

/** Used to store info on a block mainly used for rendering */
public class BlockRenderInfo
{
	/** Block lower corner size */
	public Vector3 min = new Vector3(0, 0, 0);
	/** Block higher corner size */
	public Vector3 max = new Vector3(1, 1, 1);
	/** Block to pull info from */
	public Block baseBlock = Block.sand;
	/** Override render texture */
	public IIcon texture = null;
	/** meta data to use for block the block */
	public int meta = 0;

	/** Gets the block brightness at the given location */
	public float getBlockBrightness(IBlockAccess iblockaccess, int i, int j, int k)
	{
		return baseBlock.getBlockBrightness(iblockaccess, i, j, k);
	}

	/** Gets the block texture from the given side */
	public IIcon getBlockTextureFromSide(int side)
	{
		return this.getBlockIconFromSideAndMetadata(side, meta);
	}

	/** Gets the block texture from side and meta */
	public IIcon getBlockIconFromSideAndMetadata(int side, int meta)
	{
		return this.getIconSafe(baseBlock.getIcon(side, meta));
	}

	/** Gets the icon and does some safty checks */
	public IIcon getIconSafe(IIcon par1Icon)
	{
		IIcon icon = par1Icon;
		if (this.texture != null)
		{
			icon = texture;
		}
		if (par1Icon == null)
		{
			icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
		}
		return icon;
	}
}
