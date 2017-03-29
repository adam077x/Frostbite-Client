package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.RenderUtils;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;

public class ChestESP extends Module{

	public ChestESP() {
		super("Cheat ESP", Keyboard.KEY_NONE, Category.RENDER);
	}
	public void onRender() {
		for(Object o : Wrapper.mc.theWorld.loadedTileEntityList) {
			if(o instanceof TileEntityChest) {
				RenderUtils.blockESPBox(((TileEntityChest)o).getPos());
			}
		}
	}
}	
