package org.example.item8.finalizer;

public class Account {

    private String name;

    public Account(String name) {
        if (name.equals("푸틴")) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }
}
