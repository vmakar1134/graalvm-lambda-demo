package com.makar.graalvmdemo.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.stereotype.Component;

@Component
public class StringEventHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        // Log the received string for testing
        System.out.println("Received event: " + input);

        return "Test response: " + input;
    }
}
