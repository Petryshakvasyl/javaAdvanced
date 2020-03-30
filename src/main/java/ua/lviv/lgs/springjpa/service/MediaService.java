package ua.lviv.lgs.springjpa.service;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.springjpa.entity.Media;
import ua.lviv.lgs.springjpa.entity.MediaResponce;

public interface MediaService {

    MediaResponce save(MultipartFile file);

    Media findByName(String name);

}
