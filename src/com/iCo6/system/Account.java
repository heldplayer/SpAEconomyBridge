
package com.iCo6.system;

public class Account {

    String name;

    public Account(String name) {
        this.name = name;
    }

    public Holdings getHoldings() {
        return new Holdings(this.name);
    }

    public boolean remove() {
        return false;
    }
}
