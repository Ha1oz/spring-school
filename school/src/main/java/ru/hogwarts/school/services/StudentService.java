package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repo.StudentsRepository;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student add(Student student) {
        return studentsRepository.add(student);
    }

    public Student update(Student student) {
        return studentsRepository.update(student);
    }

    public Student delete(Long id) {
        return studentsRepository.delete(id);
    }

    public Student get(Long id) {
        return studentsRepository.get(id);
    }

    public List<Student> getByAge(int age) {
        return studentsRepository.getByAge(age);
    }

    public Map<Long, Student> getAll() {
        return studentsRepository.getAll();
    }
}
