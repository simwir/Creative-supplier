package simwir.cs.client.interfaces;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class SlotFluidSupplier extends Slot{

	public SlotFluidSupplier(IInventory par1iInventory, int par2ID, int x, int y) {
		super(par1iInventory, par2ID, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		// TODO Auto-generated method stub
		return FluidContainerRegistry.isFilledContainer(par1ItemStack);
	}

}
