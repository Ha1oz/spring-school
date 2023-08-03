package ru.hogwarts.school.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.exceptions.FacultyNotFoundException;
import ru.hogwarts.school.exceptions.StudentNotFoundException;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    private Student student;
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepositoryMock;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepositoryMock);
        student = new Student(1L,"A", 23);
    }

    @Test
    void add() {
        studentService.add(student);
        Mockito.verify(studentRepositoryMock, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void update() {
        studentService.update(student);
        Mockito.verify(studentRepositoryMock, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void delete() {
        studentService.delete(student.getId());
        Mockito.verify(studentRepositoryMock, Mockito.times(1)).deleteById(Mockito.any());
    }

    @Test
    void get() {
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentService.get(student.getId()));
    }

    @Test
    void getByAge() {
        List<Student> expected = new ArrayList<>();
        expected.add(student);
        expected.add(student);

        Mockito.doReturn(expected).when(studentRepositoryMock).findByAge(Mockito.anyInt());
        Assertions.assertEquals(expected, studentService.getByAge(student.getAge()));
    }

    @Test
    void getAll() {
        List<Student> expected = new ArrayList<>();
        expected.add(student);

        Mockito.doReturn(expected).when(studentRepositoryMock).findAll();
        Assertions.assertEquals(expected, studentService.getAll());
    }
}