package ua.lviv.lgs.springjpa.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.springjpa.entity.Media;

import java.util.Optional;

public interface MediaRepository extends CrudRepository<Media, Integer> {

    Optional<Media> findByFileName(String fileName);
}
