package ru.education_platform_jma.jmacourseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.education_platform_jma.jmacourseservice.model.Course;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {
        List<Course> findByTitleContaining(String title);
        List<Course> findByPublished(boolean published);
        }
