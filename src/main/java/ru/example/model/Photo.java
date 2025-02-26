package ru.example.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "album2")
@CompoundIndex(def = "{'resolution.w': 1, 'resolution.l': 1}", name = "resolution.w_1_resolution.l_1")
public class Photo {
    @Id
    private String id;
    private String name;
    @Indexed(unique = false, name = "format_1")
    private String format;
    private int size;
    private Resolution resolution;
    private String author;
    private LocalDate date;
    
    public Photo() {}

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

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
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
    /* 
    @Override
    public String toString(){
        return "{" +
                "id='" + id + '\'' +
                ", name: '" + name + '\'' +
                ", format: '" + format + '\'' +
                ", size: " + size +
                ", resolution: {" + 
                "w: " + resolution.getW() +
                ", l: " + resolution.getL() + 
                "}" +
                ", author: '" + author + '\'' +
                ", date: '" + date + '\'' +
                "}";
    }
    */
}


