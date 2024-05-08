package org.example.item9.trywitresource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BadBufferedReaderEx {

    // 9-1 더이상 자원을 회수하는 최선의 방책이 아니다! (47p)
    public static String firstLineOfFile() throws IOException {
        BufferedReader br = new BadBufferedReader(new InputStreamReader(System.in));

        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }
}
