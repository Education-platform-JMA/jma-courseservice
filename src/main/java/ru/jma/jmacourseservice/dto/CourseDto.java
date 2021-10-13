package ru.jma.jmacourseservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.jma.jmacourseservice.model.Node;

import java.util.List;

@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CourseDto {
    private String id;
    private String name;
    private String description;
    private boolean published;
    private List<Node> nodes;
}
