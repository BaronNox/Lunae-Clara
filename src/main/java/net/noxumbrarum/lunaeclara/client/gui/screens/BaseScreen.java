package net.noxumbrarum.lunaeclara.client.gui.screens;

import net.minecraft.client.gui.GuiScreen;

public class BaseScreen extends GuiScreen{
	private boolean pauseGame;
	
	public BaseScreen() {
		this(false);
	}
	
	public BaseScreen(boolean pauseGame) {
		super();
		this.pauseGame = pauseGame;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
//		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return pauseGame;
	}
	
	public void setPauseGame(boolean value) {
		pauseGame = value;
	}
}
