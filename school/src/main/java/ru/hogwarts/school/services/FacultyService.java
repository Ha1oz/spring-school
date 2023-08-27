package ru.hogwarts.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.exceptions.FacultyNotFoundException;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class FacultyService {
    private final static Logger log = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultiesRepository) {
        this.facultyRepository = facultiesRepository;
    }

    public Faculty add(Faculty faculty) {
        log.info("Add method was invoked.");
        return facultyRepository.save(faculty);
    }

    public Faculty update(Faculty faculty) {
        log.info("Update method was invoked.");
        return facultyRepository.save(faculty);
    }

    public void delete(Long id) {
        log.info("Delete method was invoked.");
        facultyRepository.deleteById(id);
    }

    public Faculty get(Long id) {
        log.info("Get method was invoked.");
        return facultyRepository.findById(id).orElseThrow(FacultyNotFoundException::new);
    }

    public Collection<Faculty> getByColor(String color) {
        log.info("Get-by-color method was invoked.");
        return facultyRepository.findByColor(color);
    }
    public Collection<Faculty> getByName(String name) {
        log.info("Get-by-name method was invoked.");
        return facultyRepository.findByName(name);
    }

    public Collection<Faculty> getAll() {
        log.info("Get-all method was invoked.");
        return facultyRepository.findAll();
    }
    public Faculty getFacultyWithLongestName(){
        log.info("Get-faculty-with-longest-name method was invoked.");

        Collection<Faculty> faculties = facultyRepository.findAll();

        return faculties.stream()
                .parallel()
                .max(Comparator.comparingInt(f -> f.getName().length()))
                .orElseThrow(FacultyNotFoundException::new);
    }
}
