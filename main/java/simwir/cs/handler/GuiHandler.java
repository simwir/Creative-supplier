package simwir.cs.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import simwir.cs.Debug;
import simwir.cs.client.interfaces.GuiFluidSupplier;
import simwir.cs.client.interfaces.container.ContainerFluidSupplier;
import simwir.cs.tile.TileFluidSupplier;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public GuiHandler(){
		//TODO Find out if the NetworkRegistry.instance() is needed
		//NetworkRegistry.instance().registerGuiHandler(CreativeSupplier.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int par1ID, EntityPlayer par2player, World par3world, int x, int y, int z) {
		Debug.chatln("{GUIHandler} Determing what GUI to open, server side");
		switch(par1ID){
			case 0:
				TileEntity te = par3world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileFluidSupplier){
					Debug.chatln("{GUIHandler_serverside} Open Fluid Supplier");
					return new ContainerFluidSupplier(par2player.inventory, (TileFluidSupplier) te);
				}
			//TODO When IC2 is updated reimplement the power supplier
			/*	
			case 1:
				TileEntity tile = par3world.getTileEntity(x, y, z);
				if(tile != null && tile instanceof TilePowerSupplier){
					Debug.chatln("{GUIHandler_serverside} Open Power Supplier");
					return new ContainerPowerSupplier(par2player.inventory, (TilePowerSupplier) tile);
				}
			*/
				
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int par1ID, EntityPlayer par2player, World par3world, int x, int y, int z) {
		Debug.chatln("{GUIHandler} Determing what GUI to open, client side");
		switch(par1ID){
			case 0:
				TileEntity te = par3world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileFluidSupplier){
					return new GuiFluidSupplier(par2player.inventory, (TileFluidSupplier) te);
				}
			/*
			*TODO When IC2 is updated reimplement the power supplier
			case 1:
				TileEntity tile = par3world.getTileEntity(x, y, z);
				if(tile != null && tile instanceof TilePowerSupplier){
					return new GuiPowerSupplier(par2player.inventory, (TilePowerSupplier) tile);
				}
			*/
			
	}
		return null;
	}

}
