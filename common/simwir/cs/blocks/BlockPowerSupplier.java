package simwir.cs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import simwir.cs.lib.BlockReferences;
import simwir.cs.tile.TilePowerSupplier;

public class BlockPowerSupplier extends BlockContainer {

	public BlockPowerSupplier(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		setUnlocalizedName(BlockReferences.POWER_SUPPLIER_UNC_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePowerSupplier();
	}

}
