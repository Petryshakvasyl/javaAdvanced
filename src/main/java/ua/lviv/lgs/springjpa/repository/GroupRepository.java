package ua.lviv.lgs.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.springjpa.entity.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Optional<Group> findByName(String name);

    //    @Query("select g.students from ua.lviv.lgs.springjpa.entity.Group g where g.groupId = ?1")
    //    Set<Student> findGroupsStudents(Integer groupId);

}
