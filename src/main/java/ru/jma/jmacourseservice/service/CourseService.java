package ru.jma.jmacourseservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.model.Course;
import ru.jma.jmacourseservice.repository.CourseRepository;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;


    public Flux<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Mono<Course> getCourseById(final String id) {
        return courseRepository.findById(id);
    }

    public Mono<Course> saveCourse(Mono<Course> courseMono) {
        return courseMono.flatMap(courseRepository::insert);
    }

    public Mono<Course> updateCourse(Mono<Course> courseMono, String id) {
        return courseRepository.findById(id)
                .flatMap(c -> courseMono.doOnNext(e -> e.setId(id))
                        .flatMap(courseRepository::save));
    }

    public Mono<Void> deleteCourse(final String id) {
        return courseRepository.deleteById(id);
    }

    public Mono<Void> deleteAllCourses() {
        return courseRepository.deleteAll();
    }

    public Flux<Course> findByPublished(boolean published) {
        return courseRepository.findByPublished(published);
    }

    public Flux<Course> findByNameContaining(String name) {
        return courseRepository.findCourseByName(name);
    }
}





