package net.noxumbrarum.lunaeclara.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.noxumbrarum.lunaeclara.LunaeClara;
import net.noxumbrarum.lunaeclara.client.gui.GuiHandlerLunaeClara.GuiID;
import net.noxumbrarum.lunaeclara.client.gui.screens.BaseScreen;

public class ItemDev extends Item {

	public ItemDev() {
		setRegistryName("devItem");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(worldIn.isRemote) {
			playerIn.openGui(LunaeClara.instance, GuiID.ITEM_WIKI_BOOK.getId(), worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
			System.out.println("OPENED GUI");
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
		}
		
//		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn)); 
		
//		if(worldIn.isRemote) {
//			openGUI();
//		}
//		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@SideOnly(Side.CLIENT)
	private void openGUI() {
		Minecraft.getMinecraft().displayGuiScreen(new BaseScreen());
		
	}
}
