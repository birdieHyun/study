package org.example.item8.finalizer;

public class AccountHacking extends Account{

    public AccountHacking(String name) {
        super(name);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() 호출됨");
    }
}
