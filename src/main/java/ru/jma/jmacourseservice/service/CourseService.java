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
        return this.courseRepository.findAll();
    }

    public Mono<Course> getCourseById(final String id) {
        return this.courseRepository.findById(id);
    }

    public Mono<Course> saveCourse(final Course course) {
        return this.courseRepository.save(course);
    }

    public Mono<Course> updateCourse(final Course course) {
        return this.courseRepository.findById(course.getId())
                .map(p -> course)
                .flatMap(this.courseRepository::save);
    }

    public Mono<Void> deleteCourse(final String id) {
        return this.courseRepository.deleteById(id);
    }

    public Mono<Void> deleteAllCourses() {
        return this.courseRepository.deleteAll();
    }

    public Flux<Course> findByPublished(boolean published) {
        return this.courseRepository.findByPublished(published);
    }

    public Flux<Course> findByNameContaining(final String name) {
        return this.courseRepository.findCourseByName(name);
    }


}

