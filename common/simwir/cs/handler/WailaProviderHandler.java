package simwir.cs.handler;

import java.util.List;

import simwir.cs.blocks.BlockFluidSupplier;
import simwir.cs.blocks.BlockLavaSupplier;
import simwir.cs.blocks.BlockWaterSupplier;
import simwir.cs.tile.TileFluidSupplier;
import simwir.cs.tile.TileLavaSupplier;
import simwir.cs.tile.TileWaterSupplier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;

public class WailaProviderHandler implements IWailaDataProvider{

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		// TODO Auto-generated method stub
		return currenttip;
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if(accessor.getTileEntity() instanceof TileFluidSupplier){
			NBTTagCompound tag = accessor.getNBTData();
			String fluid = tag.getString("fluid");
			if(((TileFluidSupplier)accessor.getTileEntity()).fluid == null){
				if(fluid == null){
					currenttip.add("Output: Nothing");
				}else{
					currenttip.add("Output: " + fluid);
				}
				
			}else{
				currenttip.add("Output: " + ((TileFluidSupplier)accessor.getTileEntity()).fluid);
			}
		}else if(accessor.getTileEntity() instanceof TileLavaSupplier||accessor.getTileEntity() instanceof TileWaterSupplier){
			currenttip.add(EnumChatFormatting.GOLD + "This block is going to be removed");
			currenttip.add(EnumChatFormatting.GOLD + "Use Fluid Supplier instead");
		}
		return currenttip;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		// TODO Auto-generated method stub
		return currenttip;
	}
	public static void callbackRegister(IWailaRegistrar par1Registrar){
		par1Registrar.registerBodyProvider(new WailaProviderHandler(), BlockFluidSupplier.class);
		par1Registrar.registerBodyProvider(new WailaProviderHandler(), BlockWaterSupplier.class);
		par1Registrar.registerBodyProvider(new WailaProviderHandler(), BlockLavaSupplier.class);
	}

}
