package simwir.cs.handler;

/*
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
*/
/*
 * TODO Reimplement waila
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
		}else if(accessor.getTileEntity() instanceof TilePowerSupplier){
			NBTTagCompound tag = accessor.getNBTData();
			double power = tag.getDouble("power");
			currenttip.add("Output: " + power);
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
		par1Registrar.registerBodyProvider(new WailaProviderHandler(), BlockPowerSupplier.class);
	}

}
*/

