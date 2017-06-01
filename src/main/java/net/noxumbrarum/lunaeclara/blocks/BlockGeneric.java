package net.noxumbrarum.lunaeclara.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.noxumbrarum.lunaeclara.References;
import net.noxumbrarum.lunaeclara.blocks.json.BlockJsonGenerator;
import net.noxumbrarum.lunaeclara.util.Pair;

public class BlockGeneric extends Block
{
	private String registryName;
	private Pair<Block, Integer> dropBlockQuantity;
	
	private BlockGeneric(Builder builder)
	{
		super(builder.getBlockMaterial());
		registryName = builder.registryName;
		setRegistryName(builder.registryName);
		setUnlocalizedName(getRegistryName().toString());
		setSoundType(builder.getSoundType());
		setHardness(builder.getHardness());
		
		setCreativeTab(builder.creativeTabs);
		
		dropBlockQuantity = builder.getBlockDropQuantity();
		
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		
		
		devMode();
	}
	
	//TODO: Add quantity functionality.
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(dropBlockQuantity == null || dropBlockQuantity.getFirst() == null) {
			return Item.getItemFromBlock(this);
		}
		return Item.getItemFromBlock(dropBlockQuantity.getFirst());
	}
	
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, 
				new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	public static class Builder {
		private Material blockMaterial = null;
		private String registryName = null;
		private CreativeTabs creativeTabs = null;
		private SoundType soundType = null;
		private float hardness = 0.0f;
		
		private Pair<Block, Integer> blockDropQuantity = null;
		
		public Builder(String blockRegistryName, Material blockMaterial) {
			this.registryName = blockRegistryName;
			this.blockMaterial = blockMaterial;
		}
		
		public Builder setBlockDropQuantity(Pair<Block, Integer> blockDropQuantity) {
			this.blockDropQuantity = blockDropQuantity;
			return this;
		}
		
		public Builder setBlockDropQuantity(Block blockToDrop, int blockDropQuantity) {
			this.setBlockDropQuantity(new Pair<Block, Integer>(blockToDrop, blockDropQuantity));
			return this;
		}
		
		public Builder setCreativeTab(CreativeTabs creativeTabs) {
			this.creativeTabs = creativeTabs;
			return this;
		}
		
		public Builder setSoundType(SoundType soundType) {
			this.soundType = soundType;
			return this;
		}
		
		public Builder setBlockMaterial(Material blockMaterial) {
			this.blockMaterial = blockMaterial;
			return this;
		}
		
		/**
		 * Set the hardness of a block. 1.0f == stone, 50.0f == obsidian
		 * By default depends on material.
		 * @param hardness
		 * @return this for chaining.
		 */
		public Builder setHardness(float hardness)
		{
			this.hardness = hardness;
			return this;
		}
		
		public SoundType getSoundType()
		{
			return this.soundType == null ? SoundType.METAL : this.soundType;
		}
		
		public Material getBlockMaterial() {
			return this.blockMaterial == null ? Material.CLOTH : this.blockMaterial;
		}
		
		public float getHardness()
		{
			return hardness;
		}
		
		public Block getBlockToDrop() {
			return this.blockDropQuantity.getFirst();
		}
		
		public int getDropQuantity() {
			return this.blockDropQuantity.getSecond();
		}
		
		public Pair<Block, Integer> getBlockDropQuantity() {
			return this.blockDropQuantity;
		}
		
		public BlockGeneric build() {
			return new BlockGeneric(this);
		}
	}
	
	protected void devMode() {
		if(References.DEV) {
			BlockJsonGenerator.createJsons(registryName);
		}
	}

}
