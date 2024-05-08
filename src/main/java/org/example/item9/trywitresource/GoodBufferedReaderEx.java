package org.example.item9.trywitresource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodBufferedReaderEx {
    public static String firstLineOfFile() throws IOException {

        try (BufferedReader br = new BadBufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        }
    }
}
