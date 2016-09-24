package me.danielkinz.killcounter;

import org.bukkit.inventory.ItemStack;

/**
 * Allows editing the nbt of an item
 * @author Danielkinz
 */
public class NBTItem {

    private ItemStack bukkitItem;
    
    /**
     * Creates a new nbt item
     * @param item
     */
    public NBTItem(ItemStack item) {
        bukkitItem = item.clone();
    }

    /**
     * @return The modified item
     */
    public ItemStack getItem() {
        return bukkitItem;
    }

    public void setString(String key, String value) {
        bukkitItem = NBTReflectionUtils.setString(bukkitItem, key, value);
    }

    public String getString(String key) {
        return NBTReflectionUtils.getString(bukkitItem, key);
    }

    public void setInteger(String key, int value) {
        bukkitItem = NBTReflectionUtils.setInt(bukkitItem, key, value);
    }

    public Integer getInteger(String key) {
        return NBTReflectionUtils.getInt(bukkitItem, key);
    }

    public void setDouble(String key, double value) {
        bukkitItem = NBTReflectionUtils.setDouble(bukkitItem, key, value);
    }

    public double getDouble(String key) {
        return NBTReflectionUtils.getDouble(bukkitItem, key);
    }

    public void setBoolean(String key, boolean value) {
        bukkitItem = NBTReflectionUtils.setBoolean(bukkitItem, key, value);
    }

    public boolean getBoolean(String key) {
        return NBTReflectionUtils.getBoolean(bukkitItem, key);
    }

    public boolean hasKey(String key) {
        return NBTReflectionUtils.hasKey(bukkitItem, key);
    }

}