package ru.jma.jmacourseservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@Document(collection = "CourseCollection")
public class Course {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean published;
    private List<Node> nodes;
}