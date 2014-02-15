package simwir.cs.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import simwir.cs.Debug;
import simwir.cs.client.interfaces.container.ContainerPowerSupplier;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.network.PacketHandler;
import simwir.cs.tile.TilePowerSupplier;

public class GuiPowerSupplier extends GuiContainer{
	
	private TilePowerSupplier te;
	private double power;

	public GuiPowerSupplier(InventoryPlayer par1invPlayer, TilePowerSupplier te) {
		super(new ContainerPowerSupplier(par1invPlayer, te));
		
		this.te = te;
		
		xSize = 176;
		ySize = 96;
	}
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID, References.GUI_TEXTURE_LOCATION + BlockReferences.POWER_SUPPLIER_UNC_NAME + ".png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		power = te.getPower();
		
		if(power == 32){
			drawTexturedModalRect(guiLeft + 44, guiTop + 23, 0, ySize+1, 12, 10);
		}else if(power == 128){
			drawTexturedModalRect(guiLeft + 44, guiTop + 47, 0, ySize+1, 12, 10);
		}else if(power == 512){
			drawTexturedModalRect(guiLeft + 44, guiTop + 71, 0, ySize+1, 12, 10);
		}
		Debug.consoleln("te.power ==" + te.power);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString(BlockReferences.POWER_SUPPLIER_NAME, xSize/2, 6, 0x404040);
	}
	
	private static final String LOWUNCHECKED = "32 eu/t";
	private static final String LOWCHECKED = "32 eu/t [*]";
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(0, guiLeft+54, guiTop+19, 60,20, te.power == 32 ? LOWCHECKED : LOWUNCHECKED));
		buttonList.add(new GuiButton(1, guiLeft+54, guiTop+43, 60, 20, "128 eu/t"));
		buttonList.add(new GuiButton(2, guiLeft+54, guiTop+67, 60, 20, "512 eu/t"));
	}
	
	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		Debug.chatln("Button action found");
		PacketHandler.sendButtenPacket((byte)par1GuiButton.id);
		if(par1GuiButton.id == 0){
			par1GuiButton.displayString = te.power == 32 ? LOWCHECKED : LOWUNCHECKED;
		}
	}
	

}
