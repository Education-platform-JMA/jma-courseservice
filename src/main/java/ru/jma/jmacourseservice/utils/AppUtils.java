package ru.jma.jmacourseservice.utils;

import org.springframework.beans.BeanUtils;
import ru.jma.jmacourseservice.dto.CourseDTO;
import ru.jma.jmacourseservice.model.Course;

public class AppUtils {
    private AppUtils() {
    }

    public static CourseDTO entityToDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    public static Course dtoToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        return course;
    }
}
