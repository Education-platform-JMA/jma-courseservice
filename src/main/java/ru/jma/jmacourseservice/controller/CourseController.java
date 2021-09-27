package ru.jma.jmacourseservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.dto.CourseDTO;
import ru.jma.jmacourseservice.service.CourseService;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public Flux<CourseDTO> getAllCourses(@RequestParam(required = false) String name) {
        if (name == null) {
            return this.courseService.getAllCourses();
        } else {
            return this.courseService.findByNameContaining(name);
        }
    }

    @GetMapping("/{id}")
    public Mono<CourseDTO> getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Mono<CourseDTO> saveCourse(@RequestBody Mono<CourseDTO> courseDTOMono) {
        return courseService.saveCourse(courseDTOMono);
    }

    @PutMapping("/{id}")
    public Mono<CourseDTO> updateCourse(@RequestBody Mono<CourseDTO> courseDTOMono, @PathVariable String id) {
        return courseService.updateCourse(courseDTOMono, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCourse(@PathVariable("id") String id) {
        return courseService.deleteCourse(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAllCourses() {
        return courseService.deleteAllCourses();
    }

    @GetMapping("/published")
    public Flux<CourseDTO> findByPublished(boolean published) {
        return courseService.findByPublished(published);
    }

}
