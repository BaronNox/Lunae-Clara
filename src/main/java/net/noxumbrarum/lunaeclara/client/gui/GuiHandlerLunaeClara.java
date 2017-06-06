package net.noxumbrarum.lunaeclara.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.noxumbrarum.lunaeclara.client.gui.screens.BaseScreen;
import net.noxumbrarum.lunaeclara.client.gui.screens.wiki.Page;

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
		// if(ID == 1) { return new BaseScreen();}
		Class<?> screenClass = getScreenByID(ID);
		if(screenClass != null) {
			try {
				return screenClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace(); //TODO: add LOGGER
			}
		}
		return null;
	}

	public Class<?> getScreenByID(int ID) {
		for (GuiID guiID : GuiID.values()) {
			if (ID == guiID.getId()) {
				return guiID.getScreen();
			}
		}
		return null;
	}

	public static enum GuiID {
		IEST(0, BaseScreen.class),
		WIKI(1, Page.class);

		private final int id;
		private final Class<?> guiScreen;

		private GuiID(int id, Class<?> guiScreen) {
			this.id = id;
			this.guiScreen = guiScreen;
		}

		public int getId() {
			return id;
		}

		protected Class<?> getScreen() {
			return guiScreen;
		}

	}
}
