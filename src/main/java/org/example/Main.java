package org.example;

import java.io.IOException;

import static org.example.JiraCommenter.createComment;

public class Main {
    public static void main(String[] args) throws IOException {
        createComment("SFAIMP-1219", "Привет!\\n" +
                "Евгения была здесь.");
    }
}