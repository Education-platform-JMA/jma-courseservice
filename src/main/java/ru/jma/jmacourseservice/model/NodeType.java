package ru.jma.jmacourseservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "CheckBoxNodeType", value = CheckBoxNodeType.class),
        @JsonSubTypes.Type(name = "FolderNodeType", value = FolderNodeType.class),
        @JsonSubTypes.Type(name = "TestRadioNodeType", value = TestRadioNodeType.class),
        @JsonSubTypes.Type(name = "TextNodeType", value = TextNodeType.class),
        @JsonSubTypes.Type(name = "ReviewType", value = ReviewType.class)
})
public interface NodeType {
}
