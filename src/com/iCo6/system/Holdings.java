
package com.iCo6.system;

import me.heldplayer.SpAEconomy.SpAEconomy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.iCo6.iConomy;

public class Holdings {

    private String name;

    public Holdings(String name) {
        this.name = name;
    }

    public Double getBalance() {
        Player player = Bukkit.getPlayer(name);

        String account = SpAEconomy.defaultAccountName;

        if (player != null) {
            account = SpAEconomy.getAccountForWorld(player.getWorld());
        }

        if (account != null) {
            return iConomy.plugin.accounts.getBalance(name, account);
        }
        return 0.0D;
    }

    public void setBalance(double balance) {
        Player player = Bukkit.getPlayer(name);

        String account = SpAEconomy.defaultAccountName;

        if (player != null) {
            account = SpAEconomy.getAccountForWorld(player.getWorld());
        }

        if (account != null) {
            iConomy.plugin.accounts.setBalance(name, account, balance);
        }
    }

    public void add(double amount) {
        double balance = getBalance().doubleValue();
        double ending = balance + amount;

        math(amount, balance, ending);
    }

    public void subtract(double amount) {
        double balance = getBalance().doubleValue();
        double ending = balance - amount;

        math(amount, balance, ending);
    }

    public void divide(double amount) {
        double balance = getBalance().doubleValue();
        double ending = balance / amount;

        math(amount, balance, ending);
    }

    public void multiply(double amount) {
        double balance = getBalance().doubleValue();
        double ending = balance * amount;

        math(amount, balance, ending);
    }

    private void math(double amount, double balance, double ending) {
        setBalance(ending);
    }

    public boolean isNegative() {
        return getBalance().doubleValue() < 0.0D;
    }

    public boolean hasEnough(double amount) {
        return amount <= getBalance().doubleValue();
    }

    public boolean hasOver(double amount) {
        return amount < getBalance().doubleValue();
    }

    public boolean hasUnder(double amount) {
        return amount > getBalance().doubleValue();
    }
}
