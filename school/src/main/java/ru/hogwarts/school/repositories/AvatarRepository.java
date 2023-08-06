package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}
