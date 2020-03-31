package ua.lviv.lgs.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.springjpa.entity.Group;
import ua.lviv.lgs.springjpa.entity.Student;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Optional<Group> findByName(String name);

    @Query("select g.students from Group g where g.groupId = ?1")
    Set<Student> findGroupsStudents(Integer groupId);

}
