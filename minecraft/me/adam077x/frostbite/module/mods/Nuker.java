package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class Nuker extends Module{
	
	private int PosX;
	private int PosY;
	private int PosZ;
	private static int radius = 4;
	
	public Nuker(){
		super("Nuker", Keyboard.KEY_NONE, Category.WORLD);
		
	}
	@Override
	public void onUpdate(){
		if(!this.isEnabled())
			return;
		
		for(int x = -radius; x < radius; x++){
			for(int y = radius; y > -radius; y--){
				for(int z = -radius; z < radius; z++){
					this.PosX = (int)Wrapper.mc.thePlayer.posX + x;
					this.PosY = (int)Wrapper.mc.thePlayer.posY + y;
					this.PosZ = (int)Wrapper.mc.thePlayer.posZ + z;
					
					BlockPos blockPos = new BlockPos(this.PosX, this.PosY, this.PosZ);
					Block block = Wrapper.mc.theWorld.getBlockState(blockPos).getBlock();
					
					if(block.getMaterial() == Material.air)
						continue;
					
					Wrapper.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, blockPos, EnumFacing.NORTH));
					Wrapper.mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.NORTH));
					
				}
			}
		}
	}

}
