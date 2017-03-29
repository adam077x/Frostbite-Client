package me.adam077x.frostbite.module;

import me.adam077x.frostbite.event.Event;

public class Module {
	public String Name;
	public int Bind;
	public Category category;
	public boolean enabled;
	public boolean disabled;
	
	public Module(String name, int bind, Category category) {
		this.Name = name;
		this.category = category;
		this.Bind = bind;
	}
	
	public void toggleMod() {
		if(enabled == true) { enabled = false; this.onDisable(); } 
		else { enabled = true; this.onEnable(); }
	}
	
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}
	public void onEvent(Event e) {}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getBind() {
		return Bind;
	}

	public void setBind(int bind) {
		Bind = bind;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void onToggle(boolean enabled) {
		if (enabled) this.onEnable();
		if (!enabled) this.onDisable();
	}

	public boolean isToggleable() {
		return false;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean onToggle() {
		return false;
	}
}
