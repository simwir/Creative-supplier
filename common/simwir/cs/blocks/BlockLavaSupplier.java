package simwir.cs.blocks;

import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLavaSupplier extends Block{

	/**
	 * 
	 * @param par1 The block Id
	 * @param par2Material The material of the block {@link Material} 
	 */
	public BlockLavaSupplier(int par1, Material par2Material) {
		super(par1, par2Material);

		setUnlocalizedName(BlockReferences.LAVA_SUPPLIER_UNC_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	//TODO Fix block texture
	@Override
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		//this.blockIcon = par1IconRegister.registerIcon("cs:lavaSupplier");
	}

}
