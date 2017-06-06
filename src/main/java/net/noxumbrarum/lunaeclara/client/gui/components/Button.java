package net.noxumbrarum.lunaeclara.client.gui.components;

import net.minecraft.client.gui.Gui;

public class Button extends Gui {
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	public Button(int x, int y) {
		this(x, y, 50, 25);
	}
	
	public Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
