package me.adam077x.frostbite.command;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.module.mods.Bhop;
import me.adam077x.frostbite.module.mods.Mhop;

public class MhopCmd extends Command{
	
	Mhop mhop = new Mhop();
	
	@Override
	public void onCommand(String cmd, String[] args) throws Exception {
			if(args.length == 1) {
					mhop.speed = Float.parseFloat(args[0]);
					frostbite.addChatMessage("Mhop value has been changed.");
		}
	}

	@Override
	public String getAlias() {
		return "mhop";
	}

	@Override
	public String getDescription() {
		return "Change Mhop settings.";
	}

	@Override
	public String getSyntax() {
		return ".mhop [SPEED]";
	}

}
