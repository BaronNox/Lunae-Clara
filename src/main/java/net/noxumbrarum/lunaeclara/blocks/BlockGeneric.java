package net.noxumbrarum.lunaeclara.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.noxumbrarum.lunaeclara.References;
import net.noxumbrarum.lunaeclara.blocks.builder.BlockBuilder;
import net.noxumbrarum.lunaeclara.blocks.json.BlockJsonGenerator;

public class BlockGeneric extends Block
{
	private String registryName;
	
	private BlockGeneric(BlockBuilder builder)
	{
		super(builder.getBlockMaterial());
		init(builder);
		register(builder.getRegistryName());
		
		
		
		devMode();
	}
	
	private final void register(String registryName) {
		this.registryName = registryName;
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	
	private void init(BlockBuilder blockBuilder) {
		setSoundType(blockBuilder.getSoundType());
		setHardness(blockBuilder.getHardness());
		setCreativeTab(blockBuilder.getCreativeTabs());
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, 
				new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	
	public static final BlockGeneric CREATE(BlockBuilder builder) {
		return new BlockGeneric(builder);
	}
	
	protected void devMode() {
		if(References.DEV) {
			BlockJsonGenerator.createJsons(registryName);
		}
	}
}
