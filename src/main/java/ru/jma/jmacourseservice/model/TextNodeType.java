package ru.jma.jmacourseservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextNodeType implements NodeType {
    private String content;
}
