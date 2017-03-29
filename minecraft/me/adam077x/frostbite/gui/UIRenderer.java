package me.adam077x.frostbite.gui;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.utils.Wrapper;

public class UIRenderer {

	public static void renderAndUpdateFrames() {
		for(Frame f: frostbite.guiManager.getFrames()) {
			f.update();
		}
		for(Frame f : frostbite.guiManager.getFrames()) {
			if(f.isPinned() || Wrapper.mc.currentScreen instanceof GuiManagerDisplayScreen) {
				f.render();
			}
		}
	}
	
}
