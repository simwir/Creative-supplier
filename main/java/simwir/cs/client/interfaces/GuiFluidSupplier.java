package simwir.cs.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import simwir.cs.client.interfaces.container.ContainerFluidSupplier;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.tile.TileFluidSupplier;

public class GuiFluidSupplier extends GuiContainer{

	public GuiFluidSupplier(InventoryPlayer par1invPlayer, TileFluidSupplier par2fluidSupplier) {
		super(new ContainerFluidSupplier(par1invPlayer, par2fluidSupplier));
		xSize = 176;
		ySize = 154;
	}
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID, References.GUI_TEXTURE_LOCATION + BlockReferences.FLUID_SUPPLIER_UNC_NAME + ".png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
