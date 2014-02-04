package simwir.cs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import simwir.cs.blocks.BlockLavaSupplier;
import simwir.cs.blocks.BlockWaterSupplier;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class CreativeSupplier {
	
	@Instance(References.MOD_ID)
	public static CreativeSupplier instance;
	
	//Defining block and item id ints
	public static int lavaSupplierId;
	public static int waterSupplierId;
	
	//Defining blocks
	public static Block lavaSupplier;
	public static Block waterSupplier;
	
	//Defining Items
	//ex. public static Item goldDust;
	
	//Defining other things
	public static boolean debug;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("printing test");
		 Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		 
		 config.load();
		 lavaSupplierId = config.getBlock(BlockReferences.LAVA_SUPPLIER_NAME, BlockReferences.LAVA_SUPPLIER_ID).getInt();
		 waterSupplierId = config.getBlock(BlockReferences.WATER_SUPPLIER_NAME, BlockReferences.WATER_SUPPLIER_ID).getInt();
		 debug = config.get("Other", "Debug", false,References.DEBUG_CONFIG_COMMENT).getBoolean(false);
		 config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		System.out.println("printing test");
		// Adding blocks and items to the actual game
		lavaSupplier = new BlockLavaSupplier(lavaSupplierId, Material.iron);
		waterSupplier = new BlockWaterSupplier(waterSupplierId, Material.iron);
		
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
		System.out.println("printing test");
		/*
		 * There's nothing here.
		 * 
		 * Not sure if forgot something
		 * or supposed to be empty
		 */
	}
	
	private static void gameRegisters(){
		
		 // Registers blocks to the game. Seems to only be needed on blocks
		GameRegistry.registerBlock(lavaSupplier, "lavaSupplier");
		GameRegistry.registerBlock(waterSupplier, "waterSupplier");
	}
	
	private static void languageRegisters(){
		 // Registers block and item names to the game
		LanguageRegistry.addName(lavaSupplier, BlockReferences.LAVA_SUPPLIER_NAME);
		LanguageRegistry.addName(waterSupplier, BlockReferences.WATER_SUPPLIER_NAME);
	}
	
}
