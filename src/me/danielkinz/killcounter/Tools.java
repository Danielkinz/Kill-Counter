package me.danielkinz.killcounter;

import java.util.List;

import org.bukkit.ChatColor;

/**
 * A class with some usefull functions
 * 
 * @author Danielkinz
 */
public class Tools {

	/**
	 * Formats the color codes into actual colors
	 * 
	 * @param text
	 *            The text
	 * @return Formatted text
	 */
	public static String format(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	/**
	 * Formats a whole list
	 * 
	 * @param list
	 *            The list
	 * @param replacements
	 *            The placeholder values
	 * @return Formatted list
	 */
	public static List<String> formatList(List<String> list, int kills) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, format(list.get(i).replace("{kills}", String.valueOf(kills))));
		}
		return list;
	}

}
