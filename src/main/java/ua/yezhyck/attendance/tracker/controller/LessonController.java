package ua.yezhyck.attendance.tracker.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.yezhyck.attendance.tracker.domain.dto.LessonDto;
import ua.yezhyck.attendance.tracker.domain.dto.editable.LessonEditableDto;
import ua.yezhyck.attendance.tracker.service.impl.LessonServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final LessonServiceImpl lessonService;

    @Autowired
    public LessonController(LessonServiceImpl lessonService) {
        this.lessonService = lessonService;
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@RequestBody LessonEditableDto lessonEditableDto) {
        return ResponseEntity.ok(lessonService.addLesson(lessonEditableDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> readLessonById(@PathVariable("id") Long id) {
        return lessonService.getLessonById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> readAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public ResponseEntity<LessonDto> updateLessonById(@PathVariable("id") Long id, @RequestBody LessonEditableDto lessonEditableDto) {
        return ResponseEntity.ok(lessonService.modifyLessonById(id, lessonEditableDto));
    }

    @SneakyThrows
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessonById(@PathVariable("id") Long id) {
        lessonService.removeLessonById(id);

        return ResponseEntity.ok().build();
    }
}