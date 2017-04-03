package me.adam077x.frostbite.managers;

import java.util.ArrayList;

import me.adam077x.frostbite.command.*;
import me.adam077x.frostbite.main.frostbite;

public class CmdManager {

	public ArrayList<Command> commands;
	
	public CmdManager() {
		commands = new ArrayList();
		addCmd(new Bind());
		addCmd(new BhopCmd());
		addCmd(new MhopCmd());
		addCmd(new JesusCmd());
	}
	
	public void addCmd(Command cmd) {
		commands.add(cmd);
	}
	
	public ArrayList<Command> getCmds() {
		return commands;
	}
	
	public void callCmd(String input) {
		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();
		for(Command cmd : getCmds()) {
			if(cmd.getAlias().equalsIgnoreCase(command)) {
				try {
					cmd.onCommand(args, args.split(" "));
				} catch(Exception e) {
					frostbite.addChatMessage("\u00A74Invalid Command!");
					frostbite.addChatMessage(cmd.getSyntax());
				}
				return;
			}
		}
		frostbite.addChatMessage("\u00A74Command not found");
	}
}
