package simwir.cs.blocks.tooltip;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ToBeRemovedToolTip extends ItemBlock{

	public ToBeRemovedToolTip(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(EnumChatFormatting.GOLD + "This block is going to be removed");
		par3List.add(EnumChatFormatting.GOLD + "Use Fluid Supplier instead");
	}

}
