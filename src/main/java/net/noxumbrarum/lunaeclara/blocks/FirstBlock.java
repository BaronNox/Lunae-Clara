package net.noxumbrarum.lunaeclara.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.noxumbrarum.lunaeclara.blocks.json.BlockJsonGenerator;

public class FirstBlock extends Block
{
	public FirstBlock()
	{
		super(Material.ROCK);
		setRegistryName("first_block");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		BlockJsonGenerator.createJsons("first_block");
	}
}
