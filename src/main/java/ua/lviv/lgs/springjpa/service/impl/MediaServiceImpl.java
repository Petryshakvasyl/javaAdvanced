package ua.lviv.lgs.springjpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.lviv.lgs.springjpa.entity.Media;
import ua.lviv.lgs.springjpa.entity.MediaResponce;
import ua.lviv.lgs.springjpa.exceptions.NotFoundException;
import ua.lviv.lgs.springjpa.repository.MediaRepository;
import ua.lviv.lgs.springjpa.service.MediaService;

import java.io.IOException;
import java.util.Date;

@Service
@Slf4j
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public MediaResponce save(MultipartFile file) {
        Media media = new Media();
        media.setFileName(generateFileName(file));
        media.setType(file.getContentType());
        try {
            media.setData(file.getBytes());
        } catch (IOException e) {
            log.error("error while read date from file", e);
        }
        mediaRepository.save(media);
        MediaResponce response = new MediaResponce();
        response.setFileName(media.getFileName());
        response.setUrl(generateUrl(media.getFileName()));
        return response;
    }

    private String generateUrl(String fileName) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/")
                .path(fileName).toUriString();
    }

    private String generateFileName(MultipartFile file) {
        return new Date().getTime() + ".jpg";
    }

    @Override
    public Media findByName(String name) {
        return mediaRepository.findByFileName(name).orElseThrow(
                () -> new NotFoundException("media with name " + name + " not found")
        );
    }
}
