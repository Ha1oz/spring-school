package ru.hogwarts.school.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.hogwarts.school.exceptions.AvatarNotFoundException;
import ru.hogwarts.school.exceptions.FacultyNotFoundException;
import ru.hogwarts.school.exceptions.StudentNotFoundException;

@RestControllerAdvice
public class SchoolExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(SchoolExceptionHandler.class);
    @ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<Object> handleFacultyNotFoundException(FacultyNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Faculty is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Student is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AvatarNotFoundException.class)
    public ResponseEntity<Object> handleAvatarNotFoundException(AvatarNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Avatar is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Data is not found.", HttpStatus.NOT_FOUND);
    }
}
