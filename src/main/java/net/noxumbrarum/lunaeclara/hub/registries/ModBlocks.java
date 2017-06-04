package net.noxumbrarum.lunaeclara.hub.registries;

import net.minecraft.block.material.Material;
import net.noxumbrarum.lunaeclara.blocks.BlockGeneric;
import net.noxumbrarum.lunaeclara.blocks.FirstBlock;

public class ModBlocks
{
//	public static FirstBlock firstBlock;
	public static BlockGeneric SECOND_BLOCK;
	
	/**
	 * Initializes the mods by initializing the blocks.
	 */
	public static void init() {
//		firstBlock = new FirstBlock();
		SECOND_BLOCK = new BlockGeneric.Builder("first_block", Material.IRON).setHardness(0.3f).build();
	}
}
