package simwir.cs.tile;

import simwir.cs.Debug;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;

public class TilePowerSupplier extends TileEntity implements IEnergySource{
	private boolean boot = true;
	private double power;
	@Override
	public void updateEntity() {
		if(boot){
			 MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
			 boot = false;
		}
		//Debug.consoleln(""+power);
	}
	
	@Override
	public void invalidate() {
		 MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
	}
	@Override
	public void onChunkUnload() {
		MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
	}
	public double getPower(){
		//Debug.chatln("Getting power");
		double pow;
		pow = power;
		//Debug.chatln("Returning power " + pow);
		return pow;
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
		return power;
	}

	@Override
	public void drawEnergy(double amount) {}

	public void receiveButtonEvent(byte buttonId) {
		switch(buttonId){
			case 0:
				power = 32;
				Debug.chatln("Output set to " + power);
				Debug.chatln(""+power);
				break;
			case 1:
				power = 128;
				Debug.chatln("Output set to " + power);
				Debug.chatln(""+power);
				break;
			case 2:
				power = 512;
				Debug.chatln("Output set to " + power);
				Debug.chatln(""+power);
				break;
				
		}
	}
	
	/*
	 *NBT
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setDouble("power", power);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		power = par1nbtTagCompound.getDouble("power");
	}
	

}
