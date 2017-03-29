package me.adam077x.frostbite.utils;

import org.newdawn.slick.UnicodeFont;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.managers.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.network.Packet;

public class Wrapper {
	public static Minecraft mc = Minecraft.getMinecraft();	
	public static frostbite Frostbite = new frostbite();
	public static FontRenderer fr = mc.fontRendererObj;
	public static ModuleManager moduleManager;	
	public static frostbite fb;
	public static UnicodeFont unicodeFont;
}
