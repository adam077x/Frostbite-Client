package me.adam077x.frostbite.module.mods;

import java.util.List;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

import org.lwjgl.input.Keyboard;

public class Aimbot extends Module {
	public Aimbot() {
		super("Aimbot", Keyboard.KEY_NONE, Category.COMBAT);
	}

	public void onUpdate() {
		List list = Wrapper.mc.theWorld.playerEntities;

		for (int k = 0; k < list.size(); k++) {
			if (((EntityPlayer) list.get(k)).getName() == Wrapper.mc.thePlayer.getName()) {
				continue;
			}

			EntityPlayer entityplayer = (EntityPlayer) list.get(1);

			if (Wrapper.mc.thePlayer.getDistanceToEntity(entityplayer) > Wrapper.mc.thePlayer.getDistanceToEntity((Entity) list.get(k))) {
				entityplayer = (EntityPlayer) list.get(k);
			}

			float f = Wrapper.mc.thePlayer.getDistanceToEntity(entityplayer);

			if (f < 8F && Wrapper.mc.thePlayer.canEntityBeSeen(entityplayer)) {
				this.faceEntity(entityplayer);
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
}