package me.adam077x.frostbite.main;

import org.darkstorm.minecraft.gui.ExampleGuiManager;
import org.darkstorm.minecraft.gui.GuiManager;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.lwjgl.opengl.Display;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.managers.CmdManager;
import me.adam077x.frostbite.managers.ModuleManager;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.module.mods.ClickGui;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;

public class frostbite {

	public static final String Client_name = "Frostbite";
	public static final String Client_ver = "1.0b";
	
	public static ExampleGuiManager guiManager;
	
	public static CmdManager cmdManager;
	public static void InitClient() {
		System.out.println("Frostbite LOG : Running InitClient function...");
		ModuleManager.RegisterMods();
		Display.setTitle(Client_name + " (MC 1.8.8)");
		cmdManager = new CmdManager();
		frostbite.guiManager = new ExampleGuiManager();
		frostbite.guiManager.setTheme(new SimpleTheme());
		frostbite.guiManager.setup();
		ModuleManager.newMod(new ClickGui());
		System.out.println("Frostbite LOG : InitClient function finished.");
	}
	
	public static void HandleEvent(Event e) {
		for(Module m : ModuleManager.Modules) {
			if(m.enabled) { m.onEvent(e); }
		}
	}

	public static Object getClientInstance() {
		return Wrapper.Frostbite;
	}
	
	public static void addChatMessage(String s) {
		Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText("\u00A72CD1: " + s));
	}
	
	public static boolean onSendChatMessage(String s) {
		if(s.startsWith(".")){
			cmdManager.callCmd(s.substring(1));
			return false;
		}
		
		for(Module m: ModuleManager.getModules()){
			if(m.onToggle()){
				return onSendChatMessage(s);
			}
		}
		return true;
	}

	public static boolean onRecieveChatMessage(S02PacketChat packet){
		for(Module m: ModuleManager.getModules()){
			if(m.onToggle()){
				return onRecieveChatMessage(packet);
			}
		}
		return true;
	}
}
