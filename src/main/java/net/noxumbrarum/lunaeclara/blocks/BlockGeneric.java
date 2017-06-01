package net.noxumbrarum.lunaeclara.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

public class BlockGeneric extends Block
{
	private String registryName;
	
	private BlockGeneric(Builder builder)
	{
		super(builder.blockMaterial);
		registryName = builder.registryName;
		setRegistryName(builder.registryName);
		setUnlocalizedName(getRegistryName().toString());
		setSoundType(builder.getSoundType());
		setHardness(builder.getHardness());
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		
		setCreativeTab(builder.creativeTabs);
		
		devMode();
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
		
		public Builder(String blockRegistryName, Material blockMaterial) {
			this.registryName = blockRegistryName;
			this.blockMaterial = blockMaterial;
		}
		
		public Builder setCreativeTab(CreativeTabs creativeTabs) {
			this.creativeTabs = creativeTabs;
			return this;
		}
		
		public Builder setSoundType(SoundType soundType) {
			this.soundType = soundType;
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
		
		
		public float getHardness()
		{
			return hardness;
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
