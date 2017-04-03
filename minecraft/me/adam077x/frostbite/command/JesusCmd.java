package me.adam077x.frostbite.command;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.module.mods.Bhop;
import me.adam077x.frostbite.module.mods.Jesus;

public class JesusCmd extends Command{
	
	@Override
	public void onCommand(String cmd, String[] args) throws Exception {
			if(args.length == 1) {
					Jesus.JesusSpeed = Float.parseFloat(args[0]);
					frostbite.addChatMessage("Jesus Speed value has been changed.");
		}
	}

	@Override
	public String getAlias() {
		return "Jesus";
	}

	@Override
	public String getDescription() {
		return "Change Jesus settings.";
	}

	@Override
	public String getSyntax() {
		return ".jesus [SPEED]";
	}

}
