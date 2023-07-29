package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.services.FacultyService;

import java.util.List;
import java.util.Map;

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
    public Faculty delete(Long id) {
        return facultyService.delete(id);
    }

    @GetMapping
    public Faculty get(Long id) {
        return facultyService.get(id);
    }

    @GetMapping("/by-color")
    public List<Faculty> getByColor(String color) {
        return facultyService.getByColor(color);
    }

    @GetMapping("/all")
    public Map<Long, Faculty> getAll() {
        return facultyService.getAll();
    }
}
