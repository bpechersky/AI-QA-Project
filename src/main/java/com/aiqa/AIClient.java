package com.aiqa;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AIClient {
    private static final String AI_API_URL = "http://localhost:8080/answer"; // Local mock server

    public String askQuestion(String question) {
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"question\": \"" + question + "\"}")
                .post(AI_API_URL);

        return response.getBody().asString();
    }
}
