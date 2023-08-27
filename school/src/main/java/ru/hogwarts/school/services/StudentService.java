package ru.hogwarts.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.exceptions.StudentNotFoundException;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {
    private final static Logger log = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;
    private final Object flagObject = new Object();

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
    public Integer getAverageAgeMethod2() {
        log.info("Get-average-age-2 method was invoked.");

        Collection<Student> students = studentRepository.findAll();

        int sumAge = students.stream()
                .parallel()
                .mapToInt(Student::getAge)
                .sum();

        return sumAge / students.size();
    }
    public Collection<Student> getLastStudents() {
        log.info("Get-last-students method was invoked.");
        return studentRepository.getLastStudents();
    }
    public Collection<Student> getOrderedStartWithA() {
        log.info("Get-ordered-start-with-a method was invoked.");
        return studentRepository.getOrderedStudentsStartsWithA();
    }
    public Collection<String> getOrderedStartWithAMethod2() {
        log.info("Get-ordered-start-with-a-2 method was invoked.");

        Collection<Student> students = studentRepository.findAll();
        return students.stream()
                .parallel()
                .filter(s -> s.getName().startsWith("A"))
                .sorted(Comparator.comparing(Student::getName))
                .map(f -> f.getName().toUpperCase())
                .toList();
    }
    public void testThreads() {
        log.info("Test-threads method was invoked.");

        List<Student> students = studentRepository.findAll();

        doOperation(students.get(0), students.get(1));

        new Thread(() -> doOperation(students.get(2), students.get(3))).start();
        new Thread(() -> doOperation(students.get(4), students.get(5))).start();

    }
    public void testThreadsMethod2() {
        log.info("Test-threads-2 method was invoked.");

        List<Student> students = studentRepository.findAll();

        doOperationMethod2(students.get(0), students.get(1));

        new Thread(() -> doOperationMethod2(students.get(2), students.get(3)))
                .start();
        new Thread(() -> doOperationMethod2(students.get(4), students.get(5)))
                .start();

    }
    private void doOperation(Student student1, Student student2){
        System.out.println("student1 = " + student1);
        System.out.println("student2 = " + student2);
    }
    private void doOperationMethod2(Student student1, Student student2){
        synchronized (flagObject) {
            System.out.println("student1 = " + student1);
            System.out.println("student2 = " + student2);
        }
    }
}
