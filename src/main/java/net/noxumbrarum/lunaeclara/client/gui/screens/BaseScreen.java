package net.noxumbrarum.lunaeclara.client.gui.screens;

import net.minecraft.client.gui.GuiScreen;

public class BaseScreen extends GuiScreen{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		System.out.println("DRAWN");
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
