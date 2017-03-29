package me.adam077x.frostbite.module.mods;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.gui.UIRenderer;
import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class ClickGui extends Module{

	public ClickGui() {
		super("ClickGui", Keyboard.KEY_RCONTROL, Category.NONE);
	}

	public void onEnable() {
		if(!(Wrapper.mc.currentScreen instanceof GuiManagerDisplayScreen)) {
			Wrapper.mc.displayGuiScreen(new GuiManagerDisplayScreen(frostbite.guiManager));
			UIRenderer.renderAndUpdateFrames();
		}
		setEnabled(false);
	}
}
