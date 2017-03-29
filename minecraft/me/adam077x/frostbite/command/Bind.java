package me.adam077x.frostbite.command;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.managers.ModuleManager;
import me.adam077x.frostbite.module.Module;

public class Bind extends Command{

	@Override
	public void onCommand(String cmd, String[] args) throws Exception {
		if(args[0].equalsIgnoreCase("set")) {
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for(Module m : ModuleManager.getModules()) {
				if(args[1].equalsIgnoreCase(m.getName())) {
					m.setBind(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					frostbite.addChatMessage(args[1] + " has been binded to " + args[2]);
				}
			}
		}else if(args[0].equalsIgnoreCase("del")) {
			for(Module m : ModuleManager.getModules()) {
				if(m.getName().equalsIgnoreCase(args[1])) {
					m.setBind(0);
					frostbite.addChatMessage(args[1] + " has been unbinded");
				}
			}
		}else if(args[0].equalsIgnoreCase("clear")) {
			for(Module m : ModuleManager.getModules()) {
					m.setBind(0);
			}
			frostbite.addChatMessage("Keys have been cleared");
		}
	}

	@Override
	public String getAlias() {
		return "bind";
	}

	@Override
	public String getDescription() {
		return "You can change keyboard keys for mods";
	}

	@Override
	public String getSyntax() {
		return ".bind set [MOD] [KEY] | .bind del [MOD] | .bind clear";
	}

}
