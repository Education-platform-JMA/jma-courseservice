package ru.jma.jmacourseservice.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class Question {
    private String questionField;
    private List<Answer> answers;
    private List<Integer> correctAnswers;
}
