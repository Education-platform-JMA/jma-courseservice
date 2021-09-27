package ru.jma.jmacourseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.jma.jmacourseservice.model.Node;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String id;
    private String name;
    private String description;
    private boolean published;
    private List<Node> nodes;
}
