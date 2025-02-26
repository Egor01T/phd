package ru.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.example.dto.PhotoDTO;
import ru.example.service.AlbumService;

@RestController
@CrossOrigin
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public Page<PhotoDTO> getAlbumPage(
            @RequestParam(defaultValue = "0") Integer offset,              // Номер страницы
            @RequestParam(defaultValue = "10") Integer limit     // Количество элементов на странице
    ) {
        return albumService.getPhotos(PageRequest.of(offset, limit));
    }

    @GetMapping("/album/{id}")
    public PhotoDTO getAlbum(@PathVariable String id) {
        return albumService.getPhoto(id);
    }

    @PostMapping("/album")
    public PhotoDTO postPhoto(@RequestBody PhotoDTO photoDto) {
        return albumService.createPhoto(photoDto);
    }

    @DeleteMapping("/album/{id}")
    public void deletePhoto(@PathVariable String id) {
        albumService.deletePhoto(id);
    }

    @PutMapping("/album/{id}")
    public PhotoDTO putPhoto(@RequestBody PhotoDTO newPhotoDto, @PathVariable String id) {
        newPhotoDto.setId(id);
        return albumService.createPhoto(newPhotoDto);
    }
}
