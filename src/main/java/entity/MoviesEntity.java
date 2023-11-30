package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "movies", schema = "public", catalog = "")
public class MoviesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "genre_id")
    private long genreId;
    @Basic
    @Column(name = "watchlist")
    private byte watchlist;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<MovieStreamingEntity> movieStreamingsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private GenresEntity genresByGenreId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<WatchedEntity> watchedsById;

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

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public byte getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(byte watchlist) {
        this.watchlist = watchlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviesEntity that = (MoviesEntity) o;

        if (id != that.id) return false;
        if (genreId != that.genreId) return false;
        if (watchlist != that.watchlist) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (genreId ^ (genreId >>> 32));
        result = 31 * result + (int) watchlist;
        return result;
    }

    public Collection<MovieStreamingEntity> getMovieStreamingsById() {
        return movieStreamingsById;
    }

    public void setMovieStreamingsById(Collection<MovieStreamingEntity> movieStreamingsById) {
        this.movieStreamingsById = movieStreamingsById;
    }

    public GenresEntity getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(GenresEntity genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }

    public Collection<WatchedEntity> getWatchedsById() {
        return watchedsById;
    }

    public void setWatchedsById(Collection<WatchedEntity> watchedsById) {
        this.watchedsById = watchedsById;
    }
}
