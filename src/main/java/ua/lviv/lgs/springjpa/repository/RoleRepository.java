package ua.lviv.lgs.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.springjpa.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
