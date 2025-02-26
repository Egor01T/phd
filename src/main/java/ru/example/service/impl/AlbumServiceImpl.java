package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ru.example.dto.PhotoDTO;
import ru.example.repo.AlbumRepository;
import ru.example.service.AlbumService;


@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumRepository albumRepo;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepo) {
        this.albumRepo = albumRepo;
    }
    /* 
    @Override
    public long countPhotos() {
        return albumRepo.count();
    }
    */
    @Override
    public PhotoDTO createPhoto(PhotoDTO photo) {
        albumRepo.save(photo.convertToModel());
        return photo;
    }

    @Override
    public Page<PhotoDTO> getPhotos(Pageable pageable) {
        Page<PhotoDTO> photos = albumRepo.findAll(pageable).map(PhotoDTO::convertToDTO);
        //photos.map(PhotoDTO::convertToDTO);
        return photos;
    }
    /* 
    @Override
    public List<Photo> getAllPhotos() {
        return albumRepo.findAll();
    }
    */
    @Override
    public PhotoDTO getPhoto(String id) {
        return albumRepo.findById(id).map(PhotoDTO::convertToDTO).orElseThrow(() -> new RuntimeException("Фото с id=" + id + " не найдено"));
    }

    @Override
    public void deletePhoto(String id) {
        albumRepo.deleteById(id);
    }
    /* 
    @Override
    public Page<Photo> findPublishedAfter(LocalDate afterDate, Pageable pageable) {
        Page<Photo> photos = albumRepo.findByPublishedAfter(afterDate, pageable);
        return photos;
    }
    */
    /* 
    @Override
    public void deleteAllPhotos() {
        albumRepo.deleteAll();
    }
    */
    /* 
    @Override
    public void saveAllPhotos(List<Photo> photos) {
        albumRepo.saveAll(photos);
    }
    */
    /* 
    @Override
    public Page<Photo> findPhotosMatchingAll(Photo probe, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        Page<Photo> photos = albumRepo.findAll(Example.of(probe, matcher), pageable);
        return photos;
    }
    */
}
