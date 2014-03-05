package simwir.cs.utils;

import net.minecraft.item.ItemStack;

public class ItemUtils {
	/**
	 * This taked one item of the item stack and returns the rest
	 * @param par1Stack - The item stack to be subtracted from
	 * @return ItemStack - The remaining ItemStack
	 */
	public static ItemStack consumeItem(ItemStack par1Stack){
		if(par1Stack.stackSize == 1){
			//TODO Find a way to make this code work
			/*
			 * This code is currently commented out due to it never being used
			 * This method is only called one place, and the check that is run here
			 * is already being checked before this method is called
			if(par1Stack.getItem().hasContainerItem()){
				return par1Stack.getItem().getContainerItemStack(par1Stack);
			}else{
				return null;
			}
			*/
			return null;
		}else{
			par1Stack.splitStack(1);
			return par1Stack;
		}
		
	}
}
