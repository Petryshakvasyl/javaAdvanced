package ua.lviv.lgs.springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.springjpa.entity.Media;
import ua.lviv.lgs.springjpa.entity.MediaResponce;
import ua.lviv.lgs.springjpa.service.MediaService;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping()
    public MediaResponce uploadMedia(@RequestBody MultipartFile multipartFile) {
        return mediaService.save(multipartFile);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Resource> getFile(@PathVariable String name) {
        Media media = mediaService.findByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(media.getType()))
                .body(new ByteArrayResource(media.getData()));
    }

}
