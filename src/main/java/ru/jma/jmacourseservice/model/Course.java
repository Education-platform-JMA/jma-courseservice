package ru.jma.jmacourseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CourseCollection")
public class Course {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean published;
    private List<Node> nodes;
}