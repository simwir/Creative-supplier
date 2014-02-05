package simwir.cs.utils;

import net.minecraft.item.ItemStack;

public class ItemUtils {
	public static ItemStack consumeItem(ItemStack par1Stack){
		if(par1Stack.stackSize == 1){
			if(par1Stack.getItem().hasContainerItem()){
				return par1Stack.getItem().getContainerItemStack(par1Stack);
			}else{
				return null;
			}
		}else{
			par1Stack.splitStack(1);
			return par1Stack;
		}
		
	}
}
