package ua.lviv.lgs.jpa.dao;

import ua.lviv.lgs.jpa.entity.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findByEmail(String email);
}
