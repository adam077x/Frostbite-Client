package me.adam077x.frostbite.gui;

import org.lwjgl.input.Keyboard;
import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.managers.CFontManager;
import me.adam077x.frostbite.managers.ModuleManager;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.halalaboos.cfont.CFontRenderer;

public class GuiHacks {	
	public static void renderString(String text, float x, float y, int color) {
		CFontRenderer font = CFontManager.getInstance().getFont("Main_Font");
		
		font.drawStringWithShadow(text, x, y, color);
	}
	public static void renderMString(String text, float x, float y, int color) {
		CFontRenderer font1 = CFontManager.getInstance().getFont("Client_Font");
		
		font1.drawStringWithShadow(text, x, y, color);
	}
	public static void renderGameGui() {
		renderMString("\u00A7l" + frostbite.Client_name + " " + frostbite.Client_ver, 5, 5, 0x000099);
		
		for(Module m: ModuleManager.Modules) {
			if(m.enabled == true) { m.onRender(); } 
		}
		
		int yCount = 20;
		 for(Module m : ModuleManager.Modules) {
			 if(!m.enabled) continue;
			 renderString(m.Name, 5, yCount, 0x009933);
			 yCount += 10;
		 }
		 UIRenderer.renderAndUpdateFrames();
	}
}
