
package com.iCo6.system;

import java.util.List;

import me.heldplayer.SpAEconomy.SpAEconomy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Accounts {

    public boolean exists(String name) {
        Player player = Bukkit.getPlayer(name);

        String account = SpAEconomy.defaultAccountName;

        if (player != null) {
            account = SpAEconomy.getAccountForWorld(player.getWorld());
        }

        if (account != null) {
            return SpAEconomy.instance.accounts.exists(name, account);
        }
        return false;
    }

    public boolean create(String name) {
        return this.create(name, SpAEconomy.startingMoney);
    }

    public boolean create(String name, Double balance) {
        return this.create(name, balance, 0);
    }

    public boolean create(String name, Double balance, Integer status) {
        Player player = Bukkit.getPlayer(name);

        String account = SpAEconomy.defaultAccountName;

        if (player != null) {
            account = SpAEconomy.getAccountForWorld(player.getWorld());
        }

        if (account != null) {
            SpAEconomy.instance.accounts.create(name, account, balance);
            SpAEconomy.instance.accounts.setHidden(name, account, status <= 0 ? false : true);
            return true;
        }
        return false;
    }

    public Account get(String name) {
        return new Account(name);
    }

    public List<Double> getValues() {
        return null;
    }

    public boolean remove(String[] name) {
        return false;
    }

    public void purge() {}

    public void empty() {}
}
