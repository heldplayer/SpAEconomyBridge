package com.iCo6.system;

import com.SpAEconomy.SpAEconomy;
import com.iCo6.iConomy;
import java.util.List;

public class Accounts {

	public boolean exists(String name) {
		return iConomy.plugin.accounts.exists(name, false);
	}

	public boolean create(String name) {
		return create(name, SpAEconomy.startingMoney);
	}

	public boolean create(String name, Double balance) {
		return create(name, balance, 0);
	}

	public boolean create(String name, Double balance, Integer status) {
		iConomy.plugin.accounts.create(name, balance);
		iConomy.plugin.accounts.setHidden(name, status <= 0 ? false : true);
		return true;
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

	public void purge() {
	}

	public void empty() {
	}
}