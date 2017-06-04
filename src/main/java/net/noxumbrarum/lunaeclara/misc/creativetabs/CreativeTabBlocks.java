package net.noxumbrarum.lunaeclara.misc.creativetabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.noxumbrarum.lunaeclara.hub.registries.ModBlocks;

public class CreativeTabBlocks extends CreativeTabs {
	private static CreativeTabBlocks instance = null;
	
	public static CreativeTabBlocks getInstance() {
		if(instance == null) {
			instance = new CreativeTabBlocks();
		}
		
		return instance;
	}

	private CreativeTabBlocks() {
		super("ct_blocks");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.SECOND_BLOCK);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void displayAllRelevantItems(NonNullList<ItemStack> itemsOnTab) {
		for(Block block : Block.REGISTRY) {
			if(block != null && block.getUnlocalizedName().startsWith("tile.lunaeclara")) {
				block.getSubBlocks(Item.getItemFromBlock(block), this, itemsOnTab);
			}
		}
	}

}
