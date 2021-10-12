package ru.jma.jmacourseservice.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.jma.jmacourseservice.dto.CourseDto;
import ru.jma.jmacourseservice.mapper.CourseMapper;
import ru.jma.jmacourseservice.model.Course;
import ru.jma.jmacourseservice.service.CourseService;

@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public Flux<CourseDto> getAllCourses(@RequestParam(required = false) String courseName) {
        return (StringUtils.isBlank(courseName) ? courseService.getAllCourses() : courseService.findByNameContaining(courseName))
                .map(CourseMapper.INSTANCE::toDto);
    }

    @GetMapping("/{id}")
    public Mono<CourseDto> getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id)
                .map(CourseMapper.INSTANCE::toDto);
    }

    @PostMapping
    public Mono<Course> saveCourse(@RequestBody Mono<CourseDto> courseDtoMono) {
        return courseService.saveCourse(courseDtoMono.map(CourseMapper.INSTANCE::toCourse));
    }

    @PutMapping("/{id}")
    public Mono<Course> updateCourse(@RequestBody Mono<CourseDto> courseDTOMono, @PathVariable String id) {
        return courseService.updateCourse((courseDTOMono.map(CourseMapper.INSTANCE::toCourse)), id);
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
                .map(CourseMapper.INSTANCE::toDto);
    }
}
