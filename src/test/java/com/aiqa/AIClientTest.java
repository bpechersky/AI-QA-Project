package com.aiqa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AIClientTest {

    @Test
    public void testAskQuestion() {
        AIClient client = new AIClient();
        String response = client.askQuestion("What is AI?");
        Assert.assertNotNull(response);
        System.out.println("Response: " + response);
    }
}
