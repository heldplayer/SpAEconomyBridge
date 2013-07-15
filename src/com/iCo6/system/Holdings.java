
package com.iCo6.system;

import me.heldplayer.SpAEconomy.SpAEconomy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Holdings {

    private String name;

    public Holdings(String name) {
        this.name = name;
    }

    public Double getBalance() {
        Player player = Bukkit.getPlayer(this.name);

        String account = SpAEconomy.defaultAccountName;

        if (player != null) {
            account = SpAEconomy.getAccountForWorld(player.getWorld());
        }

        Double result = 0.0D;

        if (account != null) {
            result = SpAEconomy.instance.accounts.getBalance(this.name, account);
        }
        return result == null ? 0.0D : result;
    }

    public void setBalance(double balance) {
        Player player = Bukkit.getPlayer(this.name);

        String account = SpAEconomy.defaultAccountName;

        if (player != null) {
            account = SpAEconomy.getAccountForWorld(player.getWorld());
        }

        if (account != null) {
            SpAEconomy.instance.accounts.setBalance(this.name, account, balance);
        }
    }

    public void add(double amount) {
        double balance = this.getBalance();
        double ending = balance + amount;

        this.math(amount, balance, ending);
    }

    public void subtract(double amount) {
        double balance = this.getBalance();
        double ending = balance - amount;

        this.math(amount, balance, ending);
    }

    public void divide(double amount) {
        double balance = this.getBalance();
        double ending = balance / amount;

        this.math(amount, balance, ending);
    }

    public void multiply(double amount) {
        double balance = this.getBalance();
        double ending = balance * amount;

        this.math(amount, balance, ending);
    }

    private void math(double amount, double balance, double ending) {
        this.setBalance(ending);
    }

    public boolean isNegative() {
        return this.getBalance() < 0.0D;
    }

    public boolean hasEnough(double amount) {
        return amount <= this.getBalance();
    }

    public boolean hasOver(double amount) {
        return amount < this.getBalance();
    }

    public boolean hasUnder(double amount) {
        return amount > this.getBalance();
    }
}
