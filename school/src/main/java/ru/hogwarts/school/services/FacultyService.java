package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.repo.FacultyRepository;

import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultiesRepository) {
        this.facultyRepository = facultiesRepository;
    }

    public Faculty add(Faculty faculty) {
        return facultyRepository.add(faculty);
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.update(faculty);
    }

    public Faculty delete(Long id) {
        return facultyRepository.delete(id);
    }

    public Faculty get(Long id) {
        return facultyRepository.get(id);
    }

    public List<Faculty> getByColor(String color) {
        return facultyRepository.getByColor(color);
    }

    public Map<Long, Faculty> getAll() {
        return facultyRepository.getAll();
    }
}
