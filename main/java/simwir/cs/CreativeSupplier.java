package simwir.cs;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import simwir.cs.blocks.BlockFluidSupplier;
import simwir.cs.handler.GuiHandler;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.tile.TileFluidSupplier;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
public class CreativeSupplier {
	
	@Instance(References.MOD_ID)
	public static CreativeSupplier instance;
	
	//Defining blocks
	public static Block fluidSupplier;
	public static Block powerSupplier;
	
	//Defining Items
	//ex. public static Item goldDust;
	
	//Defining other things
	public static boolean debug;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		 Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		 
		 config.load();
		 debug = config.get("Other", "Debug", false,References.DEBUG_CONFIG_COMMENT).getBoolean(false);
		 config.save();
		
		 // Adding blocks and items to the actual game
		Debug.consoleln("Loading Fluid supplier");
		fluidSupplier = new BlockFluidSupplier();
		//TODO When IC2 is updated reimplement the power supplier
		//powerSupplier = new BlockPowerSupplier();
		
		//Registering blocks to game
		gameRegisters();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		
		new GuiHandler();
		
		//Adding block and item names to the game
		registerTileEntities();
		//Adding recipes
		//TODO Make recipes class if any recipes needed
		//Recipies.recipies();
		//Sending message to WAILA
		//TODO Implement Waila
		//FMLInterModComms.sendMessage("Waila", "register", "simwir.cs.handler.WailaProviderHandler.callbackRegister");
	}
	
	

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		Debug.consoleln("Debugging is turned on /n expext a lot of spam");
		/*
		 * There's nothing here.
		 * 
		 * Not sure if forgot something
		 * or supposed to be empty
		 */
	}
	
	private static void gameRegisters(){
		
		 // Registers blocks to the game. Only be needed on blocks
		GameRegistry.registerBlock(fluidSupplier, BlockReferences.FLUID_SUPPLIER_UNC_NAME);
		//GameRegistry.registerBlock(powerSupplier, BlockReferences.POWER_SUPPLIER_UNC_NAME);
	}
	
	
	private void registerTileEntities() {
		
		GameRegistry.registerTileEntity(TileFluidSupplier.class, BlockReferences.FLUID_SUPPLIER_TE_KEY);
		//TODO When IC2 is updated reimplement the power supplier
		//GameRegistry.registerTileEntity(TilePowerSupplier.class, BlockReferences.POWER_SUPPLIER_TE_KEY);
	}

}
