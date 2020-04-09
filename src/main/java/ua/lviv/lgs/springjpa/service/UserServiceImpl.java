package ua.lviv.lgs.springjpa.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.springjpa.entity.Role;
import ua.lviv.lgs.springjpa.entity.User;
import ua.lviv.lgs.springjpa.repository.RoleRepository;
import ua.lviv.lgs.springjpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User user) {
        Role role = roleRepository.save(new Role("ROLE_USER"));
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
