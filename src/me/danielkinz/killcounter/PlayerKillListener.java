package me.danielkinz.killcounter;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Contains all of the events
 * 
 * @author Danielkinz
 */
public class PlayerKillListener implements Listener {

	/**
	 * Handles kill counting
	 * 
	 * @param event
	 */
	@EventHandler
	public void onPlayerKill(PlayerDeathEvent event) {

		Player attacker = null;
		Player defender = null;
		ItemStack item = null;
		NBTItem nbt = null;
		ItemMeta meta = null;
		List<String> lore = null;
		int kills = 1;

		// Checks that both entities are players
		if (!(event.getEntity() instanceof Player && event.getEntity().getKiller() instanceof Player)) {
			return;
		}

		attacker = (Player) event.getEntity().getKiller();
		defender = (Player) event.getEntity();

		if (!defender.isDead()) {
			return;
		}

		// Checks that the item is a sword
		switch ((item = attacker.getItemInHand()).getType()) {
		case DIAMOND_SWORD:
		case GOLD_SWORD:
		case IRON_SWORD:
		case STONE_SWORD:
		case WOOD_SWORD:
			break;
		default:
			return;
		}

		// Gets the item's nbt data
		nbt = new NBTItem(item);

		// If the item already killed players before
		if (nbt.hasKey("kills")) {
			kills = nbt.getInteger("kills") + 1;
			nbt.setInteger("kills", kills);
		} else {
			nbt.setInteger("kills", 1);
		}
		
		item = nbt.getItem();
		
		meta = item.getItemMeta();
		meta.setLore(Tools.formatList(KillCounter.getLore(), kills));
		item.setItemMeta(meta);

		attacker.setItemInHand(item);

	}

}
