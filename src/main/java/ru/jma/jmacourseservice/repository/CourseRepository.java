package ru.jma.jmacourseservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.jma.jmacourseservice.model.Course;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
    Flux<Course> findByTitleContaining(String title);

    Flux<Course> findByPublished(boolean published);
}
