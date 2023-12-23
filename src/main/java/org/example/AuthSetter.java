package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AuthSetter {
    private static final String fileName = "auth.txt";
    public static String[] setAuthData() throws IOException {
        String[] logAndPass = new String[2];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        logAndPass[0] = reader.readLine();
        logAndPass[1] = reader.readLine();
        reader.close();

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("");
        fileWriter.close();

        return logAndPass;
    }
}
