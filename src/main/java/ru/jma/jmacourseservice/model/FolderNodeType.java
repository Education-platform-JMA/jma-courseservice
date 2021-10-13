package ru.jma.jmacourseservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class FolderNodeType implements NodeType {
    private List<Node> nodes;
}
