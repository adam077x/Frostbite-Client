package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Velocity extends Module{

	public static boolean Velocity;
	
	public Velocity() {
		super("NoVelocity", Keyboard.KEY_NONE, Category.COMBAT);
	}
	
	public void onEnable() {
		Velocity = true;
	}
	
	public void onDisable() {
		Velocity = false;
	}
}
