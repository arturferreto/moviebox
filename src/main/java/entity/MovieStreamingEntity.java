package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_streaming", schema = "public", catalog = "")
public class MovieStreamingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "movie_id")
    private long movieId;
    @Basic
    @Column(name = "streaming_id")
    private long streamingId;
    @Basic
    @Column(name = "rentable")
    private byte rentable;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private MoviesEntity moviesByMovieId;
    @ManyToOne
    @JoinColumn(name = "streaming_id", referencedColumnName = "id", nullable = false)
    private StreamingsEntity streamingsByStreamingId;

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

    public long getStreamingId() {
        return streamingId;
    }

    public void setStreamingId(long streamingId) {
        this.streamingId = streamingId;
    }

    public byte getRentable() {
        return rentable;
    }

    public void setRentable(byte rentable) {
        this.rentable = rentable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieStreamingEntity that = (MovieStreamingEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (streamingId != that.streamingId) return false;
        if (rentable != that.rentable) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (movieId ^ (movieId >>> 32));
        result = 31 * result + (int) (streamingId ^ (streamingId >>> 32));
        result = 31 * result + (int) rentable;
        return result;
    }

    public MoviesEntity getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(MoviesEntity moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }

    public StreamingsEntity getStreamingsByStreamingId() {
        return streamingsByStreamingId;
    }

    public void setStreamingsByStreamingId(StreamingsEntity streamingsByStreamingId) {
        this.streamingsByStreamingId = streamingsByStreamingId;
    }
}
