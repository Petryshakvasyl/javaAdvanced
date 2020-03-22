package ua.lviv.lgs.jpa.service;

import ua.lviv.lgs.jpa.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User> {

    Optional<User> findByEmail(String email);

}
