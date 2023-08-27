package ru.hogwarts.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.exceptions.StudentNotFoundException;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final static Logger log = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        log.info("Add method was invoked.");
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        log.info("Update method was invoked.");
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        log.info("Delete method was invoked.");
        studentRepository.deleteById(id);
    }

    public Student get(Long id) {
        log.info("Get method was invoked.");
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public Collection<Student> getByAge(int age) {
        log.info("Get-by-age method was invoked.");
        return studentRepository.findByAge(age);
    }
    public Collection<Student> getByAgeBetween(int min, int max) {
        log.info("Get-by-age-between-two-values method was invoked.");
        return studentRepository.findByAgeBetween(min, max);
    }
    public Collection<Student> getAll() {
        log.info("Get-all method was invoked.");
        return studentRepository.findAll();
    }
    public Integer getAmountOfAllStudents() {
        log.info("Get-amount-of-all method was invoked.");
        return studentRepository.getAmountOfAllStudents();
    }
    public Integer getAverageAge() {
        log.info("Get-average-age method was invoked.");
        return studentRepository.getAverageAge();
    }
    public Collection<Student> getLastStudents() {
        log.info("Get-last-students method was invoked.");
        return studentRepository.getLastStudents();
    }
}
