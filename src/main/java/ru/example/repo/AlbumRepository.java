package ru.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ru.example.model.Photo;

@Repository
public interface AlbumRepository extends MongoRepository<Photo,String>{
    //List<Photo> findByPublishedAfter(LocalDate date);
    //Page<Photo> findByPublishedAfter(LocalDate date, Pageable pageable);
}
