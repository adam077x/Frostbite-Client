package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AirJump extends Module{

	public AirJump() {
		super("AirJump", Keyboard.KEY_U, Category.MOVEMENT);
	}
	
	public void onEnable() {
	}
	
	public void onUpdate() {
		if(Wrapper.mc.gameSettings.keyBindJump.isPressed()) {
			Wrapper.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(false));
			Wrapper.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(Wrapper.mc.thePlayer.posX, Wrapper.mc.thePlayer.posY - 0.25D, Wrapper.mc.thePlayer.posZ, false));
			Wrapper.mc.thePlayer.onGround = true;
		}
	}
	
	public void onDisable() {
		Wrapper.mc.thePlayer.onGround = false;
	}
}
