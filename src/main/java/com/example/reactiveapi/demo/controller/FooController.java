package com.example.reactiveapi.demo.controller;

import com.example.reactiveapi.demo.entity.Foo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FooController {

    @GetMapping(value = "/foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> getFoo(){
        return Flux.interval(Duration.ofSeconds(1)).log().map(val -> new Foo(val, "My name is " + val));
    }
}
