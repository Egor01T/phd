package ru.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ru.example.dto.PhotoDTO;

public interface AlbumService {
    //long countPhotos();
    PhotoDTO createPhoto(PhotoDTO photo);
    PhotoDTO getPhoto(String id);
    void deletePhoto(String id);
    //void deleteAllPhotos();
    //void saveAllPhotos(List<Photo> photos);
    Page<PhotoDTO> getPhotos(Pageable pageable);
    //List<Photo> getAllPhotos();
    //Page<Photo> findPublishedAfter(LocalDate exclusive, Pageable pageable);
    //Page<Photo> findPhotosMatchingAll(Photo probe, Pageable pageable);
}
