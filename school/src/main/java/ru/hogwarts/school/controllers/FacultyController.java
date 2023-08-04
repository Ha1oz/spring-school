package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping
    public ResponseEntity delete(Long id) {
        facultyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Faculty> get(Long id) {
        return ResponseEntity.ok(facultyService.get(id));
    }

    @GetMapping("/by-color")
    public ResponseEntity<Collection<Faculty>> getByColor(String color) {
        return ResponseEntity.ok(facultyService.getByColor(color));
    }
    @GetMapping("/by-name")
    public ResponseEntity<Collection<Faculty>> getByName(String name) {
        return ResponseEntity.ok(facultyService.getByColor(name));
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Faculty>> getAll() {
        return ResponseEntity.ok(facultyService.getAll());
    }
    @GetMapping("/students")
    public ResponseEntity<Collection<Student>> getAllStudentsFromFaculty(Long id) {
        return ResponseEntity.ok(facultyService.get(id).getStudents());
    }
}
