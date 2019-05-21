package com.javaconsoleapp;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ConfigEvent;
import org.springframework.boot.SpringApplication;

public class AppHandler
        implements RequestHandler<ConfigEvent, String>{

    @Override
    public String handleRequest(ConfigEvent event,
                                Context context) {
        String logString = String.format("Rule Name %s parameters %s : %s",
                event.getConfigRuleName(), event.getRuleParameters(), event.toString());
        context.getLogger().log(logString);

        SpringApplication.run(SpringBootAwsLambdaApplication.class);
        LambdaLogger logger = context.getLogger();
        logger.log("This works");

        return "Scheduled handler returns: " + logString + " " + event.toString() + " " + context.toString();
    }
}
