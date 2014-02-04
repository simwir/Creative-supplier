package simwir.cs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class Debug {
	private static boolean debug = CreativeSupplier.debug;
	public static void consoleln(String par1Message){
		if(debug){
			System.out.println("[Creative-Supplier]"+"[Debug]"+par1Message);
		}
	}
	public static void chatln(String par1Message){
		if(debug){
			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(ChatMessageComponent.createFromText("[Creative-Supplier]"+"[Debug]"+par1Message));
		}
	}
	public void chatln(String par1Message, EntityPlayer par2Player){
		if(debug){
			par2Player.addChatMessage("[Creative-Supplier]"+"[Debug]"+par1Message);
		}
	}
	/*
	public static void chatDebuggerln(String par1Message){
		EntityPlayer player = CreativeSupplier.debugger;
		if(debug){
			
		}
	}
	*/

}
