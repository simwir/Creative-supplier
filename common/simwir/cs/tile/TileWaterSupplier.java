package simwir.cs.tile;


import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import simwir.cs.handler.TankHandler;
import simwir.cs.lib.BlockReferences;

public class TileWaterSupplier extends TileLavaSupplier{
	public final TankHandler tank = new TankHandler(BlockReferences.WATER_SUPPLIER_UNC_NAME, 16000, this);
	private String fluid = "water";
	
	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return FluidRegistry.getFluidStack(this.fluid, maxDrain);
	}
}
