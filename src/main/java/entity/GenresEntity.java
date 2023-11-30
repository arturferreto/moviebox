package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "genres", schema = "public", catalog = "")
public class GenresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "genresByGenreId")
    private Collection<MoviesEntity> moviesById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenresEntity that = (GenresEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<MoviesEntity> getMoviesById() {
        return moviesById;
    }

    public void setMoviesById(Collection<MoviesEntity> moviesById) {
        this.moviesById = moviesById;
    }
}
