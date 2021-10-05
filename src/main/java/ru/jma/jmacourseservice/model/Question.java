package ru.jma.jmacourseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private String questionField;
    private List<Answer> answers;
    private List<Integer> correctAnswers;
}
