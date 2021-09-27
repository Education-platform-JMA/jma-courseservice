package ru.jma.jmacourseservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.jma.jmacourseservice.dto.CourseDTO;
import ru.jma.jmacourseservice.model.Course;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
    Flux<CourseDTO> findCourseByName(String name);

    Flux<CourseDTO> findByPublished(boolean published);
}
