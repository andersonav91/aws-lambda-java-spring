package com.javaconsoleapp;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ConfigEvent;
import org.springframework.boot.SpringApplication;

import java.util.Map;

public class AppHandler
        implements RequestHandler<Map, String>{

    @Override
    public String handleRequest(Map event,
                                Context context) {
        SpringApplication.run(SpringBootAwsLambdaApplication.class);
        LambdaLogger logger = context.getLogger();
        if(event.containsKey("args")) {
            String args = event.get("args").toString();
            String logString = String.format("Args is %s", args);
            logger.log(logString);
        }
        logger.log("All Parameters and data");
        context.getLogger().log(event.toString());
        return "Scheduled handler returns:  " + event.toString();
    }
}
