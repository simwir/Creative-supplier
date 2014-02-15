package simwir.cs.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import simwir.cs.CreativeSupplier;
import simwir.cs.Debug;
import simwir.cs.lib.BlockReferences;
import simwir.cs.lib.References;
import simwir.cs.tile.TilePowerSupplier;

public class BlockPowerSupplier extends BlockContainer {

	public BlockPowerSupplier(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		setUnlocalizedName(BlockReferences.POWER_SUPPLIER_UNC_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePowerSupplier();
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		Debug.chatln("Power Supplier Right clicked");
		
		TilePowerSupplier tile = (TilePowerSupplier)par1World.getBlockTileEntity(x, y, z);
		
		if(tile != null){
			FMLNetworkHandler.openGui(par5EntityPlayer, CreativeSupplier.instance, 1, par1World, x, y, z);
		}
		return false;
	}

}
