package ru.jma.jmacourseservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class Node {
    private String id;
    private String title;
    private NodeType nodeType;
}
