package ru.jma.jmacourseservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.jma.jmacourseservice.dto.CourseDto;
import ru.jma.jmacourseservice.model.Course;

@Mapper()
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto toDto(Course course);

    Course toCourse(CourseDto courseDto);
}
