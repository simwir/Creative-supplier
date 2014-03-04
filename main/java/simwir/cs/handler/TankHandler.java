package simwir.cs.handler;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;

public class TankHandler extends FluidTank{

	private final String name;
	
	public TankHandler(String name, int capacity, TileEntity tile) {
		super(capacity);
		this.name = name;
		this.tile = tile;
	}
	public Fluid getFluidType() {
		return getFluid() != null ? getFluid().getFluid() : null;
	}
	@Override
	public final NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		NBTTagCompound tankData = new NBTTagCompound();
		super.writeToNBT(tankData);
		writeToNBT(tankData);
		nbt.setCompoundTag(name, tankData);
		return nbt;
	}

	@Override
	public final FluidTank readFromNBT(NBTTagCompound nbt) {
		if (nbt.hasKey(name)) {
			NBTTagCompound tankData = nbt.getCompoundTag(name);
			super.readFromNBT(tankData);
			readFromNBT(tankData);
		}
		return this;
	}
	@Override
    public FluidTankInfo getInfo()
    {
        return new FluidTankInfo(this);
    }

}
