package org.example.item8.autocloseable;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class CloseableIsGood implements Closeable {

    private final BufferedReader br;

    public CloseableIsGood() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void close() throws IOException {
        br.close();
        System.out.println("close 호출");
    }
}
