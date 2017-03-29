package me.adam077x.frostbite.module.mods;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class Killaura extends Module{
	int delay;
	public static float yaw;
	public static float pitch;
	public Killaura() {
		super("Killaura", Keyboard.KEY_R, Category.COMBAT);
	}
	public void onUpdate() {
		for(Object o: Wrapper.mc.theWorld.loadedEntityList) {
			if(o instanceof EntityPlayer) {
				EntityPlayer ep = (EntityPlayer)o;
				if(!(ep instanceof EntityPlayerSP) && Wrapper.mc.thePlayer.getDistanceToEntity(ep) <= 5.5 && !ep.isDead && Wrapper.mc.thePlayer.canEntityBeSeen(ep)) {
					this.faceEntity(ep);
					Wrapper.mc.thePlayer.swingItem();
					Wrapper.mc.playerController.attackEntity(Wrapper.mc.thePlayer, ep);
					delay = 0;
				}
			}
		}
	}
	
	public static synchronized void faceEntity(EntityLivingBase entity) {
		final float[] rotations = getRotationsNeeded(entity);

		if (rotations != null) {
			Wrapper.mc.thePlayer.rotationYaw = rotations[0];
			Wrapper.mc.thePlayer.rotationPitch = rotations[1] + 1.0F;// 14
		}
	}

	public static float[] getRotationsNeeded(Entity entity) {
		if (entity == null) {
			return null;
		}

		final double dX = entity.posX - Wrapper.mc.thePlayer.posX;
		final double dZ = entity.posZ - Wrapper.mc.thePlayer.posZ;
		
		double diffY;
		if (entity instanceof EntityLivingBase) {
			final EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			diffY = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (Wrapper.mc.thePlayer.posY + Wrapper.mc.thePlayer.getEyeHeight());
		} 
		else {
			diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (Wrapper.mc.thePlayer.posY + Wrapper.mc.thePlayer.getEyeHeight());
		}

		final double dist = MathHelper.sqrt_double(dX * dX + dZ * dZ);
		final float yaw = (float) (Math.atan2(dZ, dX) * 180.0D / Math.PI) - 90.0F;
		final float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / Math.PI);
		return new float[] { Wrapper.mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - Wrapper.mc.thePlayer.rotationYaw), Wrapper.mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - Wrapper.mc.thePlayer.rotationPitch) };
	}
	
	public void onDisable() {
	}
	
}
