package net.noxumbrarum.lunaeclara.hub.registries;

import net.minecraft.block.material.Material;
import net.noxumbrarum.lunaeclara.blocks.BlockGeneric;
import net.noxumbrarum.lunaeclara.blocks.FirstBlock;

public class ModBlocks
{
//	public static FirstBlock firstBlock;
	public static BlockGeneric secondBlock;
	
	public static void init() {
//		firstBlock = new FirstBlock();
		secondBlock = new BlockGeneric.Builder("first_block", Material.IRON).build();
	}
}
