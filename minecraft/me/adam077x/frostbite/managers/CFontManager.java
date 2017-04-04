package me.adam077x.frostbite.managers;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import net.halalaboos.cfont.CFontRenderer;

public class CFontManager {

	public static CFontManager fontmanager;
	
	public Map<String, CFontRenderer> fm;
	
	public CFontManager() {
		this.fm = new HashMap<String, CFontRenderer>();
		
		this.fm.put("Main_Font", new CFontRenderer(new Font("Arial", Font.PLAIN, 20), true, false));
		this.fm.put("Client_Font", new CFontRenderer(new Font("Verdana", Font.PLAIN, 30), true, false));
	}
	
	public static CFontManager getInstance() {
		if(fontmanager == null) {
			fontmanager = new CFontManager();
		}
		
		
		
		return fontmanager;
	}

	public static CFontManager getFontmanager() {
		return fontmanager;
	}
	
	public CFontRenderer getFont(String font) {
		return this.fm.get(font);
	}

	public static void setFontmanager(CFontManager fontmanager) {
		CFontManager.fontmanager = fontmanager;
	}

	public Map<String, CFontRenderer> getFm() {
		return fm;
	}

	public void setFm(Map<String, CFontRenderer> fm) {
		this.fm = fm;
	}
}
