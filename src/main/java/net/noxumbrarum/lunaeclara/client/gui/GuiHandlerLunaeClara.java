package net.noxumbrarum.lunaeclara.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.noxumbrarum.lunaeclara.client.gui.screens.BaseScreen;

/*
 * registered in init of commonProxy
 */
public class GuiHandlerLunaeClara implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println(ID + " called");
//		getScreen(ID);
		if(ID == 1) { return new BaseScreen();}
		return null;
	}

	private BaseScreen getScreen(int id) {
		System.out.println("inside getScreen");
		for (GuiID guiID : GuiID.values()) {
			System.out.println("inside for each");
			if (guiID.getId() == id) {
				System.out.println("ID found");
				try {
					System.out.println("CREATED");
					return guiID.getScreenClass().newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static enum GuiID {
		ITEM_WIKI_BOOK(1, BaseScreen.class);

		private final int id;
		private final Class<BaseScreen> guiScreen;

		private GuiID(int id, Class<BaseScreen> guiScreen) {
			this.id = id;
			this.guiScreen = guiScreen;
		}

		public int getId() {
			return id;
		}
		
		public Class<BaseScreen> getScreenClass() {
			return guiScreen;
		}
	}
}
