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
    public Faculty update(@RequestBody Faculty faculty) {
        return facultyService.update(faculty);
    }

    @DeleteMapping
    public ResponseEntity delete(Long id) {
        facultyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Faculty get(Long id) {
        return facultyService.get(id);
    }

    @GetMapping("/by-color")
    public Collection<Faculty> getByColor(String color) {
        return facultyService.getByColor(color);
    }
    @GetMapping("/by-name")
    public Collection<Faculty> getByName(String name) {
        return facultyService.getByColor(name);
    }

    @GetMapping("/all")
    public Collection<Faculty> getAll() {
        return facultyService.getAll();
    }
    @GetMapping("/students")
    public Collection<Student> getAllStudentsFromFaculty(Long id) {
        return facultyService.get(id).getStudents();
    }
}
