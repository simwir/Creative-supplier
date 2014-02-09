package simwir.cs.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import simwir.cs.CreativeSupplier;
import simwir.cs.Debug;
import simwir.cs.client.interfaces.ContainerFluidSupplier;
import simwir.cs.client.interfaces.GuiFluidSupplier;
import simwir.cs.tile.TileFluidSupplier;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(CreativeSupplier.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int par1ID, EntityPlayer par2player, World par3world, int x, int y, int z) {
		Debug.chatln("{GUIHandler} Determing what GUI to open, server side");
		switch(par1ID){
			case 0:
				TileEntity te = par3world.getBlockTileEntity(x, y, z);
				if(te != null && te instanceof TileFluidSupplier){
					return new ContainerFluidSupplier(par2player.inventory, (TileFluidSupplier) te);
				}
				
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int par1ID, EntityPlayer par2player, World par3world, int x, int y, int z) {
		Debug.chatln("{GUIHandler} Determing what GUI to open, client side");
		switch(par1ID){
		case 0:
			TileEntity te = par3world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileFluidSupplier){
				return new GuiFluidSupplier(par2player.inventory, (TileFluidSupplier) te);
			}
			
	}
		return null;
	}

}
