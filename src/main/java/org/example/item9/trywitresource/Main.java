package org.example.item9.trywitresource;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BadBufferedReader br = new BadBufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            System.out.println("catch readline error");
        }finally {
            br.close();
        }
    }
}
