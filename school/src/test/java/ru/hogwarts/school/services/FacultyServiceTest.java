package ru.hogwarts.school.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.exceptions.FacultyNotFoundException;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {
    private Faculty faculty;
    private FacultyService facultyService;
    @Mock
    private FacultyRepository facultyRepositoryMock;

    @BeforeEach
    void setUp() {
        facultyService = new FacultyService(facultyRepositoryMock);
        faculty = new Faculty(1L,"A", "green");
    }

    @Test
    void add() {
        facultyService.add(faculty);
        Mockito.verify(facultyRepositoryMock, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void update() {
        facultyService.update(faculty);
        Mockito.verify(facultyRepositoryMock, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void delete() {
        facultyService.delete(faculty.getId());
        Mockito.verify(facultyRepositoryMock, Mockito.times(1)).deleteById(Mockito.any());
    }

    @Test
    void get() {
        Assertions.assertThrows(FacultyNotFoundException.class,() -> facultyService.get(faculty.getId()));
    }

    @Test
    void getByColor() {
        List<Faculty> expected = new ArrayList<>();
        expected.add(faculty);
        expected.add(faculty);

        Mockito.doReturn(expected).when(facultyRepositoryMock).findByColor(Mockito.anyString());
        Assertions.assertEquals(expected, facultyService.getByColor(faculty.getColor()));
    }

    @Test
    void getAll() {
        List<Faculty> expected = new ArrayList<>();
        expected.add(faculty);

        Mockito.doReturn(expected).when(facultyRepositoryMock).findAll();
        Assertions.assertEquals(expected, facultyService.getAll());
    }
}