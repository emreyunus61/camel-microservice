package com.example.camelmicroservice.router.b;

import org.apache.camel.builder.RouteBuilder;

public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

      from("file:files/input")
              .to("file:files/output");

    }
}
