package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.List;
import java.util.Map;

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
    public Student delete(long id) {
        return studentService.delete(id);
    }

    @GetMapping
    public Student get(long id) {
        return studentService.get(id);
    }

    @GetMapping("/by-age")
    public List<Student> getByAge(int age) {
        return studentService.getByAge(age);
    }

    @GetMapping("/all")
    public Map<Long, Student> getAll() {
        return studentService.getAll();
    }
}
