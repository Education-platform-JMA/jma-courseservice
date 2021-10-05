package ru.jma.jmacourseservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.dto.CourseDto;
import ru.jma.jmacourseservice.model.Course;
import ru.jma.jmacourseservice.service.CourseService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public Flux<CourseDto> getAllCourses(@RequestParam(required = false) String name) {
        if (name == null) {
            return courseService.getAllCourses()
                    .map(course -> objectMapper.convertValue(course, CourseDto.class));
        } else {
            return courseService.findByNameContaining(name)
                    .map(course -> objectMapper.convertValue(course, CourseDto.class));
        }
    }

    @GetMapping("/{id}")
    public Mono<CourseDto> getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id)
                .map(course -> objectMapper.convertValue(course, CourseDto.class));
    }

    @PostMapping
    public Mono<Course> saveCourse(@RequestBody Mono<CourseDto> courseDtoMono) {
        return courseService.saveCourse(courseDtoMono.map(courseDto -> objectMapper.convertValue(courseDto, Course.class)));
    }

    @PutMapping("/{id}")
    public Mono<Course> updateCourse(@RequestBody Mono<CourseDto> courseDTOMono, @PathVariable String id) {
        return courseService.updateCourse((courseDTOMono.map(courseDto -> objectMapper.convertValue(courseDto, Course.class))), id);
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
    public Flux<CourseDto> findByPublished(boolean published) {
        return courseService.findByPublished(published)
                .map(course -> objectMapper.convertValue(course, CourseDto.class));
    }
}
