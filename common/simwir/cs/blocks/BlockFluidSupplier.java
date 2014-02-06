package simwir.cs.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
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
import simwir.cs.CreativeSupplier;
import simwir.cs.Debug;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.tile.TileFluidSupplier;
import simwir.cs.utils.ItemUtils;

public class BlockFluidSupplier extends BlockContainer{

	private String name = BlockReferences.LAVA_SUPPLIER_NAME;
	/**
	 * @param par1 The block Id
	 * @param par2Material The material of the block {@link Material} 
	 */
	public BlockFluidSupplier(int par1, Material par2Material) {
		super(par1, par2Material);

		setUnlocalizedName(BlockReferences.FLUID_SUPPLIER_UNC_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	}
	
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		Debug.chatln(name + " Right clicked");
		ItemStack heldItem = par5EntityPlayer.inventory.getCurrentItem();
		if(FluidContainerRegistry.isEmptyContainer(heldItem)){
			Debug.chatln("Empty fluid container found");
			//TODO Edit this so that it returns correct fluid and not just lava
			FluidStack available = FluidRegistry.getFluidStack(TileFluidSupplier.fluid, 1000);
			ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(available, heldItem);
			if(fillStack != null){
				Debug.chatln("Filling container");
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
		}else if(FluidContainerRegistry.isFilledContainer(heldItem)){
				par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, null);
				TileFluidSupplier.changeFluid(FluidRegistry.getFluidName(FluidContainerRegistry.getFluidForFilledItem(heldItem)));
				Debug.chatln("Changed fluid");
				return true;
			
		}else{
			Debug.chatln("Didn't find empty fluid container checking if world isn't remote");
			if(!par1World.isRemote){
				FMLNetworkHandler.openGui(par5EntityPlayer, CreativeSupplier.instance, 0, par1World, x, y, z);
				Debug.chatln("world isn't remote opening GUI");
			}
			return true;
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileFluidSupplier();
	}


	

}
