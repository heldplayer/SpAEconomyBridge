
package com.iCo6;

import java.util.logging.Logger;

import me.heldplayer.SpAEconomy.SpAEconomy;

import org.bukkit.plugin.java.JavaPlugin;

public class iConomy extends JavaPlugin {

    private static final Logger log = Logger.getLogger("SpAEconomy");

    @Override
    public void onDisable() {
        info("Disabled!");
    }

    @Override
    public void onEnable() {
        info("Enabled!");
    }

    public static String format(double amount) {
        return SpAEconomy.formatMoney(amount);
    }

    public static void warning(String message) {
        log.warning("[iConomy] [Spoof]" + message);
    }

    public static void info(String message) {
        log.info("[iConomy] [Spoof]" + message);
    }

    public static void debug(String message) {
        log.info("[DEBUG] " + message);
    }
}
