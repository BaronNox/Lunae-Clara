package net.noxumbrarum.lunaeclara.client.gui.screens.wiki;

import net.noxumbrarum.lunaeclara.client.gui.screens.BaseScreen;
import net.noxumbrarum.lunaeclara.util.GuiUtil;

public class Page extends BaseScreen {
	
	public Page() {
		super();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		System.out.println(width +":"+ height+":"+ mc.displayWidth+":"+mc.displayHeight);
		drawRect(0, 0, width, height, GuiUtil.GuiColors.ORANGE.getColor());
	}
}
