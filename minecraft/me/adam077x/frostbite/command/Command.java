package me.adam077x.frostbite.command;

public abstract class Command {

	public abstract void onCommand(String cmd, String[] args) throws Exception;
	public abstract String getAlias();
	public abstract String getDescription();
	public abstract String getSyntax();
}
