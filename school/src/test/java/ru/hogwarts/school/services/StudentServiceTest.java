package ru.hogwarts.school.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repo.FacultyRepository;
import ru.hogwarts.school.repo.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
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
        Mockito.verify(studentRepositoryMock, Mockito.times(1)).add(Mockito.any());
    }

    @Test
    void update() {
        studentService.update(student);
        Mockito.verify(studentRepositoryMock, Mockito.times(1)).update(Mockito.any());
    }

    @Test
    void delete() {
        studentService.delete(student.getId());
        Mockito.verify(studentRepositoryMock, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void get() {
        Student expected = student;

        Mockito.doReturn(expected).when(studentRepositoryMock).get(Mockito.any());
        Assertions.assertEquals(expected, studentService.get(student.getId()));
    }

    @Test
    void getByAge() {
        List<Student> expected = new ArrayList<>();
        expected.add(student);
        expected.add(student);

        Mockito.doReturn(expected).when(studentRepositoryMock).getByAge(Mockito.anyInt());
        Assertions.assertEquals(expected, studentService.getByAge(student.getAge()));
    }

    @Test
    void getAll() {
        Map<Long, Student> expected = new HashMap<>();
        expected.put(student.getId(), student);

        Mockito.doReturn(expected).when(studentRepositoryMock).getAll();
        Assertions.assertEquals(expected, studentService.getAll());
    }
}