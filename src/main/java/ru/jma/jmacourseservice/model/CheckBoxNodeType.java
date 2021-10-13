package ru.jma.jmacourseservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CheckBoxNodeType implements NodeType {
    private Question question;
}
