package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repo.StudentRepository;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentsRepository) {
        this.studentRepository = studentsRepository;
    }

    public Student add(Student student) {
        return studentRepository.add(student);
    }

    public Student update(Student student) {
        return studentRepository.update(student);
    }

    public Student delete(Long id) {
        return studentRepository.delete(id);
    }

    public Student get(Long id) {
        return studentRepository.get(id);
    }

    public List<Student> getByAge(int age) {
        return studentRepository.getByAge(age);
    }

    public Map<Long, Student> getAll() {
        return studentRepository.getAll();
    }
}
