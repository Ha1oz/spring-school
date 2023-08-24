package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping
    public ResponseEntity delete(long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Student get(long id) {
        return studentService.get(id);
    }

    @GetMapping("/by-age")
    public Collection<Student> getByAge(int age) {
        return studentService.getByAge(age);
    }
    @GetMapping("/by-age-between")
    public Collection<Student> getByAge(int minAge, int maxAge) {
        return studentService.getByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/all")
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/faculty")
    public Faculty getFacultyFromStudent(Long id) {
        return studentService.get(id).getFaculty();
    }
}
