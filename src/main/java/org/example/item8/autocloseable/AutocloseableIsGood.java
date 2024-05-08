package org.example.item8.autocloseable;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AutocloseableIsGood implements AutoCloseable {

    private final BufferedReader br;

    public AutocloseableIsGood() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void close() throws Exception {
        br.close();
        System.out.println("close 호출");
    }
}
