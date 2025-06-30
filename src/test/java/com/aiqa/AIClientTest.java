package com.aiqa;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class AIClientTest {
    private WireMockServer wireMockServer;
    @BeforeClass
    public void startMockServer() {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
        configureFor("localhost", 8080);

        stubFor(post(urlEqualTo("/api/chat"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"response\":\"Hello, how can I help you?\"}")));
    }


    @Test
    public void testAskQuestion() {
        AIClient client = new AIClient();
        String response = client.askQuestion("What is AI?");
        Assert.assertNotNull(response);
        System.out.println("Response: " + response);
    }
}
