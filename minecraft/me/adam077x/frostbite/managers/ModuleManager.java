package me.adam077x.frostbite.managers;

import java.util.ArrayList;

import org.darkstorm.minecraft.gui.ExampleGuiManager;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

import me.adam077x.frostbite.main.frostbite;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.module.mods.*;

public class ModuleManager {

	public static ArrayList<Module> Modules = new ArrayList<Module>();
	
	public static void RegisterMods() {
		newMod(new Step());
		newMod(new Sprint());
		newMod(new Blink());
		newMod(new CreativeFly());
		newMod(new TimerMod());
		newMod(new Aimbot());
		newMod(new Brightness());
		newMod(new Multiaura());
		newMod(new Nofall());
		newMod(new AirJump());
		newMod(new Bhop());
		newMod(new Mhop());
		newMod(new ChestESP());
		newMod(new Criticals());
		newMod(new Killaura());
		newMod(new FastPlace());
		newMod(new Jesus());
		newMod(new Nuker());
		newMod(new Velocity());
	}
	
	public static void newMod(Module m) {
		Modules.add(m);
	}

	public static ArrayList<Module> getModules() {
		return Modules;
	}

}
