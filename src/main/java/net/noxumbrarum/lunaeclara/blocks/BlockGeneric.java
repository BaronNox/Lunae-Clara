package net.noxumbrarum.lunaeclara.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGeneric extends Block
{
	private String registryName;
	
	private BlockGeneric(Builder builder)
	{
		super(builder.blockMaterial);
		registryName = builder.registryName;
		setRegistryName(builder.registryName);
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		
		setCreativeTab(builder.creativeTabs);
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
		
		public Builder(String blockRegistryName, Material blockMaterial) {
			this.registryName = blockRegistryName;
			this.blockMaterial = blockMaterial;
		}
		
		public Builder setCreativeTab(CreativeTabs creativeTabs) {
			this.creativeTabs = creativeTabs;
			return this;
		}
		
		public BlockGeneric build() {
			return new BlockGeneric(this);
		}
	}

}
