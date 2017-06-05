package net.noxumbrarum.lunaeclara.hub.registries;

import net.noxumbrarum.lunaeclara.blocks.BlockGeneric;
import net.noxumbrarum.lunaeclara.blocks.builder.BlockBuilder;

public class ModBlocks
{
//	public static FirstBlock firstBlock;
	public static BlockGeneric SECOND_BLOCK;
	
	/**
	 * Initializes the mods by initializing the blocks.
	 */
	public static void init() {
//		firstBlock = new FirstBlock();
		SECOND_BLOCK = (BlockGeneric) new BlockBuilder("first_block").setHardness(0.3f).build();
	}
}
