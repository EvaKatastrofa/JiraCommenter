package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Base64;

import static org.example.AuthSetter.setAuthData;

public class JiraCommenter {
    private static final String BASE_URL = "https://jira.moscow.alfaintra.net";

    public static void createComment(String issueKey, String commentBody) throws IOException {
        RestAssured.baseURI = BASE_URL;
        String requestBody = "{\"body\": \"" + commentBody + "\"}";

        String[] logAndPass = setAuthData();
        String login = logAndPass[0];
        String password = logAndPass[1];

        Response response = RestAssured
                .given()
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((login + ":" + password).getBytes()))
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/rest/api/2/issue/" + issueKey + "/comment");

        // Проверка статуса ответа
        if (response.getStatusCode() == 201) {
            System.out.println("The comment has created successfully");
        } else {
            System.out.println("An error occurred when creating a comment. Error code: " + response.getStatusCode());
        }
    }
}
