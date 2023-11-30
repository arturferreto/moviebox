package com.ifrs.moviebox.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "streamings", schema = "public", catalog = "")
public class Streamings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "streamingsByStreamingId")
    private Collection<MovieStreaming> movieStreamingsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Streamings that = (Streamings) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<MovieStreaming> getMovieStreamingsById() {
        return movieStreamingsById;
    }

    public void setMovieStreamingsById(Collection<MovieStreaming> movieStreamingsById) {
        this.movieStreamingsById = movieStreamingsById;
    }
}
