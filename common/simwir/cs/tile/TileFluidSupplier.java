package simwir.cs.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import simwir.cs.handler.TankHandler;
import simwir.cs.lib.BlockReferences;

public class TileFluidSupplier extends TileEntity implements IFluidHandler, IInventory{
	public final TankHandler tank = new TankHandler(BlockReferences.FLUID_SUPPLIER_UNC_NAME, 16000, this);
	public static String fluid = null;
	private ItemStack items;
	
	public TileFluidSupplier(){
		//TODO find out if this is needed
		//items = new ItemStack;
	}
	
	/*
	 * Custom code
	 */
	public static void changeFluid(String par1fluid){
		fluid = par1fluid;
	}
	
	@Override
	public void updateEntity() {
		if(items != null){
			changeFluid(FluidRegistry.getFluidName(FluidContainerRegistry.getFluidForFilledItem(items)));
			decrStackSize(0, 1);
		}
	}
	
	/*
	 * IFluidHandler
	 */
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource == null)
			return null;
		if (!resource.isFluidEqual(tank.getFluid()))
			return null;
		return drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return FluidRegistry.getFluidStack(TileFluidSupplier.fluid, maxDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[]{tank.getInfo()};
	}

	/*
	 * IInventory
	 */
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public ItemStack decrStackSize(int par1slot, int par2count) {
		ItemStack itemstack = getStackInSlot(par1slot);
		
		if(itemstack!=null){
			if(itemstack.stackSize <= par2count){
				setInventorySlotContents(par1slot, null);
			}else{
				itemstack = itemstack.splitStack(par2count);
				onInventoryChanged();
			}
		}
		
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return item;
	}

	@Override
	public void setInventorySlotContents(int par1slot, ItemStack par2itemstack) {
		items = par2itemstack;
		onInventoryChanged();
		
	}

	@Override
	public String getInvName() {return null;}

	@Override
	public boolean isInvNameLocalized() {return false;}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1entityplayer) {
		return par1entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int par1slot, ItemStack par2itemstack) {
		return FluidContainerRegistry.isFilledContainer(par2itemstack);
	}
	/*
	 * NBT
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setString("fluid", fluid);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		TileFluidSupplier.fluid = par1nbtTagCompound.getString("fluid");
	}
}
