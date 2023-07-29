package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.repo.FacultiesRepository;

import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    private final FacultiesRepository facultiesRepository;

    public FacultyService(FacultiesRepository facultiesRepository) {
        this.facultiesRepository = facultiesRepository;
    }

    public Faculty add(Faculty faculty) {
        return facultiesRepository.add(faculty);
    }

    public Faculty update(Faculty faculty) {
        return facultiesRepository.update(faculty);
    }

    public Faculty delete(Long id) {
        return facultiesRepository.delete(id);
    }

    public Faculty get(Long id) {
        return facultiesRepository.get(id);
    }

    public List<Faculty> getByColor(String color) {
        return facultiesRepository.getByColor(color);
    }

    public Map<Long, Faculty> getAll() {
        return facultiesRepository.getAll();
    }
}
