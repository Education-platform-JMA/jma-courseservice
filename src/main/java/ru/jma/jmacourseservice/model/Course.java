package ru.jma.jmacourseservice.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "CourseCollection")
public class Course {
    @Id
    private String id;
    private String title;
    private String description;
    private boolean published;
}