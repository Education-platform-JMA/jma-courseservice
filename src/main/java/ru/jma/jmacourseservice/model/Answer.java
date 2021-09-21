package ru.jma.jmacourseservice.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Answer {
    private long code;
    private String text;
}
