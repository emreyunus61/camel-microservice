package com.example.camelmicroservice.router;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private  GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private  SimpleLoggingProcessingComponent  loggingComponent;

    @Override
    public void configure() throws Exception {

        //timer ,transformation,log

        from("timer:first-timer")//null
                .log("${body}")
                .transform().constant("My Constant message")
                .log("${body}")
                //.transform().constant("Time now is "+ LocalDateTime.now())
                //.bean("getCurrentTimeBean")
                .bean(getCurrentTimeBean)
                .log("${body}") //Time now is 2022..
                .bean(loggingComponent)
                .log("${body}")
                .to("log:first-timer");//database

    }
}

@Component
class GetCurrentTimeBean{
    public  String GetCurrentTime(){
        return "Time now is "+ LocalDateTime.now();

    }
}

@Component
class SimpleLoggingProcessingComponent{

    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
    public  void  process(String message){

        logger.info("SimpleLoggingProcessingComponent {}",message);
    }
}


