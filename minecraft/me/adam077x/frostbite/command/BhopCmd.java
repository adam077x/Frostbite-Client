package me.adam077x.frostbite.command;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.module.mods.Bhop;

public class BhopCmd extends Command{
	
	Bhop bhop = new Bhop();
	
	@Override
	public void onCommand(String cmd, String[] args) throws Exception {
			if(args.length == 1) {
					bhop.speed = Float.parseFloat(args[0]);
					frostbite.addChatMessage("Bhop value has been changed.");
		}
	}

	@Override
	public String getAlias() {
		return "bhop";
	}

	@Override
	public String getDescription() {
		return "Change Bhop settings.";
	}

	@Override
	public String getSyntax() {
		return ".bhop [SPEED]";
	}

}
