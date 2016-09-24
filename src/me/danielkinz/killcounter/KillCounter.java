package me.danielkinz.killcounter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * KillCounter plugin
 * @author Danielkinz
 */
public class KillCounter extends JavaPlugin {

	private static List<String> lore = null;
	public static Logger logger = null;

	/**
	 * Called when the plugin starts
	 */
	@Override
	public void onEnable() {
		// Registers the default configs
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		// Reads the custom lore
		lore = getConfig().getStringList("Lore");
		
		// Registers the listeners
		Bukkit.getPluginManager().registerEvents(new PlayerKillListener(), this);
		
		// Registers the logger
		logger = getLogger();
	}

	/**
	 * @return The custom lore
	 */
	public static List<String> getLore() {
		return new ArrayList<String>(lore);
	}

}
