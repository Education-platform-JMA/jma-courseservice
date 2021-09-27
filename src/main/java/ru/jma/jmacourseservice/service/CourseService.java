package ru.jma.jmacourseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.dto.CourseDTO;
import ru.jma.jmacourseservice.repository.CourseRepository;
import ru.jma.jmacourseservice.utils.AppUtils;


@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Flux<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .map(AppUtils::entityToDto);
    }

    public Mono<CourseDTO> getCourseById(final String id) {
        return courseRepository.findById(id)
                .map(AppUtils::entityToDto);
    }

    public Mono<CourseDTO> saveCourse(Mono<CourseDTO> courseDTOMono) {
        return courseDTOMono.map(AppUtils::dtoToEntity)
                .flatMap(courseRepository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<CourseDTO> updateCourse(Mono<CourseDTO> courseDTOMono, String id) {
        return courseRepository.findById(id)
                .flatMap(c -> courseDTOMono.map(AppUtils::dtoToEntity))
                .doOnNext(e -> e.setId(id))
                .flatMap(courseRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteCourse(final String id) {
        return courseRepository.deleteById(id);
    }

    public Mono<Void> deleteAllCourses() {
        return courseRepository.deleteAll();
    }

    public Flux<CourseDTO> findByPublished(boolean published) {
        return courseRepository.findByPublished(published);
    }

    public Flux<CourseDTO> findByNameContaining(String name) {
        return courseRepository.findCourseByName(name);
    }


}


