package com.aiqa;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class MockServer {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
        wireMockServer.start();

        wireMockServer.stubFor(post(urlEqualTo("/answer"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"answer\": \"Artificial Intelligence is the simulation of human intelligence.\" }")));

        System.out.println("✅ Mock server running at http://localhost:8080");
    }
}