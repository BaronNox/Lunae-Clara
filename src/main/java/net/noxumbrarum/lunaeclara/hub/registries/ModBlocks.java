package net.noxumbrarum.lunaeclara.hub.registries;

import net.noxumbrarum.lunaeclara.blocks.FirstBlock;

public class ModBlocks
{
	public static FirstBlock firstBlock;
	
	public static void init() {
		firstBlock = new FirstBlock();
	}
}
