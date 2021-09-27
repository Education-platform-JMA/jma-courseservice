package ru.jma.jmacourseservice.model;

import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.List;

@SuppressWarnings("java:S116")

@Data
@Component
public class Node {
    private String id;
    private String title;
    private String type;
    private String content;
    private String question;
    private List<Integer> correct_answers;
    private String correct_answer;
    private List<Node> nodes;
    private List<Answer> answers;
}
