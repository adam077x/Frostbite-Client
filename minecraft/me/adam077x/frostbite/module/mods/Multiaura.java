package me.adam077x.frostbite.module.mods;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class Multiaura extends Module{

	public Multiaura() {
		super("Multiaura", Keyboard.KEY_NONE, Category.COMBAT);
	}
	
	  @Override
	    public void onUpdate() {
	        for(Iterator<Entity> entities = Wrapper.mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
	            Object theObject = entities.next();
	            if(theObject instanceof EntityLivingBase) {
	                EntityLivingBase entity = (EntityLivingBase) theObject;
	               
	                if(entity instanceof EntityPlayerSP) continue;
	                if(Wrapper.mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
	                    if(entity.isEntityAlive()) {
	                        Wrapper.mc.playerController.attackEntity(Wrapper.mc.thePlayer, entity);
	                        Wrapper.mc.thePlayer.swingItem();
	                        continue;
	                    }
	                }
	            }
	        }
	  }
}
