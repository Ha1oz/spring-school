package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(Integer age);
    List<Student> findByAgeBetween(Integer min, Integer max);
    @Query(value="SELECT COUNT(name) AS amount FROM student", nativeQuery = true)
    Integer getAmountOfAllStudents();
    @Query(value="SELECT AVG(age) AS average FROM student", nativeQuery = true)
    Integer getAverageAge();
    @Query(value="SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> getLastStudents();
    @Query(value="SELECT * FROM student WHERE name LIKE 'A%' ORDER BY name", nativeQuery = true)
    List<Student> getOrderedStudentsStartsWithA();

}
