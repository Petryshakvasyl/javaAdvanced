package ua.lviv.lgs.springjpa.service;

import ua.lviv.lgs.springjpa.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Group create(Group group);

    Optional<Group> findById(Integer id);

    List<Group> findAll();

    void deleteById(Integer id);

    Group update(Group student);

}
