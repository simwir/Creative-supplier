package simwir.cs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import simwir.cs.Debug;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.tile.TileLavaSupplier;
import simwir.utils.ItemUtils;

public class BlockLavaSupplier extends BlockContainer{

	/**
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
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		Debug.chatln("Lava supplier Right clicked");
		ItemStack heldItem = par5EntityPlayer.inventory.getCurrentItem();
		if(FluidContainerRegistry.isBucket(heldItem)){
			FluidStack available = FluidRegistry.getFluidStack("lava", 1000);
			ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(available, heldItem);
			if(fillStack != null){
				if(heldItem.stackSize == 1){
					par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, fillStack);
				}else{
					par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, ItemUtils.consumeItem(heldItem));
					if(!par5EntityPlayer.inventory.addItemStackToInventory(fillStack)){
						par5EntityPlayer.dropPlayerItem(fillStack);
					}
				}
				return true;
			}
		}else{
			return false;
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileLavaSupplier();
	}


	

}
