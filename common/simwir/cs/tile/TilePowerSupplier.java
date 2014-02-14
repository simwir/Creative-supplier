package simwir.cs.tile;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;

public class TilePowerSupplier extends TileEntity implements IEnergySource{
	private boolean boot = true;
	@Override
	public void updateEntity() {
		if(boot){
			 MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
			 boot = false;
		}
	}
	
	@Override
	public void invalidate() {
		 MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
	}
	@Override
	public void onChunkUnload() {
		MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
	}

	/*
	 * IEnergySource
	 */
	@Override
	public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
		return true;
	}

	@Override
	public double getOfferedEnergy() {
		return 512;
	}

	@Override
	public void drawEnergy(double amount) {}
	
	
	

}
