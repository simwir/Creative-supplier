package simwir.cs;

import net.minecraftforge.common.Configuration;
import simwir.cs.lib.References;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class CreativeSupplier {
	
	@Instance(References.MOD_ID)
	public static CreativeSupplier instance;
	
	/*
	 * This is where block and items defining id's and defining the block and items are going to be
	 * Defining id's
	 *ex. ppublic static int pureGoldShovelId;
	 *
	 *Defining blocks and items
	 *ex. public static Block blockPureIron;
	 *ex. public static Item goldDust;
	 *TODO Define Items and Blocks to the game
	 */
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		 Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		 
		 config.load();
		 //TODO Add stuff to the config
		 //ex.  pureIronId = config.getItem(ItemReferences.PURE_IRON_NAME, ItemReferences.PURE_IRON_DEFAULT_ID).getInt();
		 config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		/*
		 * Adding blocks and items to the actual game
		 * ex. blockPureIron = new BlockPureIron(blockPureIronId,Material.iron);
		 * ex. blockPureGold = new BlockPureGold(blockPureGoldId,Material.iron);
		 * TODO Add blocks and items to game
		 */
		//Registering blocks to game
		gameRegisters();
		//Adding block and item names to the game
		languageRegisters();
		//Adding recipes
		//TODO Make recipes class if any recipes needed
		//Recipies.recipies();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		/*
		 * There's nothing here.
		 * 
		 * Not sure if forgot something
		 * or supposed to be empty
		 */
	}
	
	private static void gameRegisters(){
		/*
		 * Registers blocks to the game. Seems to only be needed on blocks
		 * ex. GameRegistry.registerBlock(blockPureIron, "blockPureIron");
		 * TODO Register blocks to the game.
		 */
	}
	
	private static void languageRegisters(){
		/*
		 * Registers block and item names to the game
		 * ex. LanguageRegistry.addName(blockPureIron, BlockReferences.BLOCK_PURE_IRON_NAME);
		 * ex. LanguageRegistry.addName(pureIron, ItemReferences.PURE_IRON_NAME);
		 * TODO Add block and item names to game
		 */
	}
	
}
