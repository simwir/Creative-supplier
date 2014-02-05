package simwir.cs.blocks;

import simwir.cs.Debug;
import simwir.cs.lib.BlockReferences;
import simwir.cs.tile.TileWaterSupplier;
import simwir.cs.utils.ItemUtils;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockWaterSupplier extends BlockLavaSupplier{
	private String name = BlockReferences.WATER_SUPPLIER_NAME;

	public BlockWaterSupplier(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName(BlockReferences.WATER_SUPPLIER_UNC_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		Debug.chatln(name + " Right clicked");
		ItemStack heldItem = par5EntityPlayer.inventory.getCurrentItem();
		if(FluidContainerRegistry.isBucket(heldItem)){
			FluidStack available = FluidRegistry.getFluidStack("water", 1000);
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
		return new TileWaterSupplier();
	}
}
