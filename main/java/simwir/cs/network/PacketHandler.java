package simwir.cs.network;

//import net.minecraft.network.INetworkManager;
//import net.minecraft.network.packet.Packet250CustomPayload;

//import cpw.mods.fml.common.network.IPacketHandler;
//import cpw.mods.fml.common.network.PacketDispatcher;
//import cpw.mods.fml.common.network.Player;
/*
 * TODO Find out how to do a packet handler and if it's even needed
public class PacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		
		Debug.chatln("Packet recived");
		
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
		
		switch(packetId){
			case 0:
				Debug.chatln("Packet indentified ad butten packet");
				byte buttonId = reader.readByte();
				Container container = entityPlayer.openContainer;
				if(container != null && container instanceof ContainerPowerSupplier){
					TilePowerSupplier powerSupplier = ((ContainerPowerSupplier)container).getPowerSupplier();
					Debug.chatln("Senden run to powerSupplier.reciveButtonEvent");
					powerSupplier.receiveButtonEvent(buttonId);
				}
				break;
		}
		
	}
	
	public static void sendButtenPacket(byte id){
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);
		
		try{
			dataStream.writeByte((byte)0);
			dataStream.writeByte(id);
			Debug.chatln("Sending packet to server");
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(References.CHANNEL, byteStream.toByteArray()));
		}catch(IOException ex){
			System.err.append("Failed to send button click packet");
		}
	}

}
*/
