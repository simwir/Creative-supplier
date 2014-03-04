package simwir.cs.client.interfaces.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import simwir.cs.tile.TilePowerSupplier;

public class ContainerPowerSupplier extends Container {

	private TilePowerSupplier tilepower;
	
	
	public ContainerPowerSupplier(InventoryPlayer par1invPlayer, TilePowerSupplier te) {
		this.tilepower = te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public TilePowerSupplier getPowerSupplier(){
		return tilepower;
	}

}
