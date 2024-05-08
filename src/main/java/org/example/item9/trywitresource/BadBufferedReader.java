package org.example.item9.trywitresource;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamCorruptedException;

public class BadBufferedReader extends BufferedReader {

    public BadBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        System.out.println("readLine 호출");
        throw new CharConversionException();
    }

    @Override
    public void close() throws IOException {
        System.out.println("close 호출");
        throw new StreamCorruptedException();
    }
}
