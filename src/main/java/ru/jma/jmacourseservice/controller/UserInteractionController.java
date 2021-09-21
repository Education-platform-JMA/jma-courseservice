package ru.jma.jmacourseservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.jma.dto.swagger.MessageDto;
import ru.jma.jmacourseservice.service.InteractionService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserInteractionController {

    private final InteractionService userInteractionService;

    @GetMapping("/test")
    public Mono<MessageDto> getMyData() {
        return Mono.just(
                new MessageDto("hi! i'm test action in CourseService", LocalDateTime.now(), false)
        );
    }

    @GetMapping("/test-remote")
    public Mono<MessageDto> getDataFromCourseService() {
        return userInteractionService.getMono("test", MessageDto.class);
    }
}

