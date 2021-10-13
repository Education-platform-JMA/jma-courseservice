package ru.jma.jmacourseservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@Document(collection = "CourseCollection")
public class Course {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean published;
    private List<Node> nodes;
}