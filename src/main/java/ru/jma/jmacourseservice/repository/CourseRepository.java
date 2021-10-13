package ru.jma.jmacourseservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.jma.jmacourseservice.model.Course;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
    Flux<Course> findCourseByName(String name);

    Flux<Course> findByPublished(boolean published);
}
