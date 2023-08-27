package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.exceptions.StudentNotFoundException;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student get(Long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public Collection<Student> getByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> getByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
    public Integer getAmountOfAllStudents() {
        return studentRepository.getAmountOfAllStudents();
    }
    public Integer getAverageAge() {
        return studentRepository.getAverageAge();
    }
    public Collection<Student> getLastStudents() {
        return studentRepository.getLastStudents();
    }
}
