package ru.jma.jmacourseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderNodeType implements NodeType {
    private List<Node> nodes;
}
