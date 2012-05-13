package com.iCo6;

import com.SpAEconomy.SpAEconomy;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class iConomy extends JavaPlugin {

	private static final Logger log = Logger.getLogger("SpAEconomy");
	private static String moneyname;
	public static SpAEconomy plugin;
	public static Server Server;

	@Override
	public void onDisable() {
		info("Disabled!");
	}

	@Override
	public void onEnable() {
		Server = this.getServer();
		plugin = (SpAEconomy) getServer().getPluginManager().getPlugin("SpAEconomy");
		moneyname = plugin.getMoneyName();

		info("Enabled!");
	}

	public static double roundToDecimals(double value, int decimals) {
		int temp = (int) ((value * Math.pow(10, decimals)));
		return (((double) temp) / Math.pow(10, decimals));
	}

	public static String format(double amount) {
		return roundToDecimals(amount, 2) + " " + moneyname;
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