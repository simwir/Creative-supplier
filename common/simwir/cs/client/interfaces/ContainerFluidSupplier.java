package simwir.cs.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import simwir.cs.tile.TileFluidSupplier;

public class ContainerFluidSupplier extends Container{
	
	private TileFluidSupplier fluidSupplier;

	public ContainerFluidSupplier(InventoryPlayer par1invPlayer, TileFluidSupplier par2fluidSupplier) {
		this.fluidSupplier = par2fluidSupplier;
		
		//adding inventory slots
		for(int i = 0; i < 9; i++){
			addSlotToContainer(new Slot(par1invPlayer, i, 8 + 18 * i, 130));
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(par1invPlayer, x + y * 9 + 9,8+18*x, 72 + y * 18 ));
			}
		}
		//adding container slots
		addSlotToContainer(new SlotFluidSupplier(par2fluidSupplier, 1, 80, 29));
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1entityplayer) {
		return fluidSupplier.isUseableByPlayer(par1entityplayer);
	}
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;
		//return super.transferStackInSlot(par1EntityPlayer, par2);
	}

}
