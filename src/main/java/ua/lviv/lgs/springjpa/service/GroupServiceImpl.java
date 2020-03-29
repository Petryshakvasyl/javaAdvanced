package ua.lviv.lgs.springjpa.service;

import ua.lviv.lgs.springjpa.entity.Group;
import ua.lviv.lgs.springjpa.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Optional<Group> findById(Integer id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        groupRepository.findById(id);
    }

    @Override
    public Group update(Group student) {
        return groupRepository.save(student);
    }
}
