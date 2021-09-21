package ru.jma.jmacourseservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.model.Course;
import ru.jma.jmacourseservice.service.CourseService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;


    @GetMapping
    public Flux<Course> getAllCourses(@RequestParam(required = false) String name) {
        if (name == null) {
            return this.courseService.getAllCourses();
        } else {
            return this.courseService.findByNameContaining(name);
        }
    }

    @GetMapping("/{id}")
    public Mono<Course> getCourseById(@PathVariable("id") String id) {
        return this.courseService.getCourseById(id);
    }

    @PostMapping
    public Mono<Course> saveCourse(@RequestBody Course course) {
        return this.courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    public Mono<Course> updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCourse(@PathVariable("id") String id) {
        return this.courseService.deleteCourse(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAllCourses() {
        return this.courseService.deleteAllCourses();
    }

    @GetMapping("/published")
    public Flux<Course> findByPublished(boolean published) {
        return this.courseService.findByPublished(published);
    }

}
