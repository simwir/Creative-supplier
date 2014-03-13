package simwir.cs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import simwir.cs.CreativeSupplier;
import simwir.cs.Debug;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.tile.TileFluidSupplier;
import simwir.cs.utils.ItemUtils;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidSupplier extends BlockContainer{

	
	public BlockFluidSupplier() {
		super(Material.iron);
		Debug.consoleln("Fluid supplier registerd");
		setBlockName(BlockReferences.FLUID_SUPPLIER_UNC_NAME);
		//TODO Make it so it doesn't throw an error when you open you inventory
		this.setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister){
		Debug.consoleln("Registering texture for Fluid Supplier");
		this.blockIcon = par1IconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
		Debug.consoleln("Registered texture for fluid supplier");
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		Debug.chatln("Fluid Supplier Right clicked");
		
		TileFluidSupplier tilefluidsupplier = (TileFluidSupplier) par1World.getTileEntity(x, y, z);
		ItemStack heldItem = par5EntityPlayer.inventory.getCurrentItem();
		
		if(tilefluidsupplier != null){
			Debug.chatln("Tile entity found at location");
			
			if(FluidContainerRegistry.isEmptyContainer(heldItem)){
				Debug.chatln("Empty fluid container found");
				FluidStack available = FluidRegistry.getFluidStack(tilefluidsupplier.fluid, 1000);
				ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(available, heldItem);
				
				if(fillStack != null){
					Debug.chatln("Filling container");
					
					if(heldItem.stackSize == 1){
						par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, fillStack);
						
					}else{
						par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, ItemUtils.consumeItem(heldItem));
						
						if(!par5EntityPlayer.inventory.addItemStackToInventory(fillStack)){
							ForgeHooks.onPlayerTossEvent(par5EntityPlayer, fillStack, true);
						}
					}
					return true;
				}
			}else if(FluidContainerRegistry.isFilledContainer(heldItem)){
				if(FluidRegistry.getFluidName(FluidContainerRegistry.getFluidForFilledItem(heldItem))==tilefluidsupplier.fluid){
					Debug.chatln("Fluid Spplier alreade set to " + tilefluidsupplier.fluid);
					return true;
				}else{
					par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, null);
					
					tilefluidsupplier.changeFluid(FluidRegistry.getFluidName(FluidContainerRegistry.getFluidForFilledItem(heldItem)));
					Debug.chatln("Changed fluid");
					return true;
				}
				
			}else{
				Debug.chatln("Didn't find empty fluid container checking if world isn't remote");
				if(!par1World.isRemote){
					FMLNetworkHandler.openGui(par5EntityPlayer, CreativeSupplier.instance, 0, par1World, x, y, z);
					Debug.chatln("world isn't remote opening GUI");
				}
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileFluidSupplier();
	}

	

}
