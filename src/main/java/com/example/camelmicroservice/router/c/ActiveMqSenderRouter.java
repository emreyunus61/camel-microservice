package com.example.camelmicroservice.router.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //timer
        from("timer:active-mq-timer?period=1000")
                .transform().constant("My message for active mq")
                .to("activemq:my-activemq-queue");
          //queue
    }




}
