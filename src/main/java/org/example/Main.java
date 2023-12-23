package org.example;

import java.io.IOException;

import static org.example.JiraCommenter.createComment;

public class Main {
    public static void main(String[] args) throws IOException {
        String baseURL = "Введите URL на ресурс jira";
        String issueKey = "Введите ID задачи";
        String comment = "Введите комментарий";

        createComment(baseURL, issueKey, comment);
    }
}