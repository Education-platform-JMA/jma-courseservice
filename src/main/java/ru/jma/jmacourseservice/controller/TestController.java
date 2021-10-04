package ru.jma.jmacourseservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/1")
    public String test1() {
        log.info("request '/courses/test/1' was sent");
        return "test endpoint 1";
    }
}
