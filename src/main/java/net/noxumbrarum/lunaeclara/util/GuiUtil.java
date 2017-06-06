package net.noxumbrarum.lunaeclara.util;

import net.minecraft.util.ResourceLocation;
import net.noxumbrarum.lunaeclara.References;

public class GuiUtil {
	public static ResourceLocation getResourceLocation(String elementName) {
		return new ResourceLocation(References.MODID, "textures/gui/" + elementName);
	}
	
	public static int getColor(int a, int r, int g, int b) {
		int color = (a << 24) + (r << 16) + (g << 8) + b;
		return color;
	}
	
	public static enum GuiColors {
		BLACK(GuiUtil.getColor(255, 0, 0, 0)),
		ORANGE(GuiUtil.getColor(255, 255, 127, 36)),
		GREY(GuiUtil.getColor(255, 66, 66, 66));
		
		private final int color;
		private GuiColors(int color) {
			this.color = color;
		}
		
		public int getColor() {
			return color;
		}
	}
}
