package ua.lviv.lgs.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.springjpa.entity.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Optional<Group> findByName(String name);

}
