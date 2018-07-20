package com.distribuida.rest.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Album implements Serializable {

    private Long id;
    private int version;
    private String title;
    private Date releaseDate;
    private Long singer_id;

    public Album () {
    }

    public Album (String title, Date releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Album (Long id, String title, Date releaseDate, Long singer_id) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.singer_id = singer_id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getSinger_id ( ) {
        return singer_id;
    }

    public void setSinger_id (Long singer_id) {
        this.singer_id = singer_id;
    }

    @Override
    public String toString ( ) {
        return "Album{" +
                "id=" + id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", singer_id=" + singer_id +
                '}';
    }
}
