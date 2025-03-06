package ru.example.dto;

import java.io.Serializable;
import java.time.LocalDate;

import ru.example.model.Photo;
import ru.example.model.Resolution;

public class PhotoDTO implements Serializable {
    private String id;
    private String name;
    private String format;
    private int size;
    private int w;
    private int l;
    private String author;
    private LocalDate date;

    public PhotoDTO(){}

    public static PhotoDTO convertToDTO(Photo photo){
        PhotoDTO dto = new PhotoDTO();
        dto.setId(photo.getId());
        dto.setName(photo.getName());
        dto.setFormat(photo.getFormat());
        dto.setSize(photo.getSize());
        dto.setW(photo.getResolution().getW());
        dto.setL(photo.getResolution().getL());
        dto.setAuthor(photo.getAuthor());
        dto.setDate(photo.getDate());
        return dto;
    }

    public Photo convertToModel(){
        Photo model = new Photo();
        model.setId(id);
        model.setName(name);
        model.setFormat(format);
        model.setSize(size);
        Resolution res = new Resolution();
        res.setW(w);
        res.setL(l);
        model.setResolution(res);
        model.setAuthor(author);
        model.setDate(date);
        return model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
