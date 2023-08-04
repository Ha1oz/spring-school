package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.exceptions.FacultyNotFoundException;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultiesRepository) {
        this.facultyRepository = facultiesRepository;
    }

    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    public Faculty get(Long id) {
        return facultyRepository.findById(id).orElseThrow(FacultyNotFoundException::new);
    }

    public List<Faculty> getByColor(String color) {
        return facultyRepository.findByColor(color);
    }
    public List<Faculty> getByName(String name) {
        return facultyRepository.findByName(name);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}
