package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "watched", schema = "public", catalog = "")
public class WatchedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "movie_id")
    private long movieId;
    @Basic
    @Column(name = "rating")
    private short rating;
    @Basic
    @Column(name = "remark")
    private String remark;
    @Basic
    @Column(name = "favorite")
    private byte favorite;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private MoviesEntity moviesByMovieId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte getFavorite() {
        return favorite;
    }

    public void setFavorite(byte favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchedEntity that = (WatchedEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (rating != that.rating) return false;
        if (favorite != that.favorite) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (movieId ^ (movieId >>> 32));
        result = 31 * result + (int) rating;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (int) favorite;
        return result;
    }

    public MoviesEntity getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(MoviesEntity moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }
}
