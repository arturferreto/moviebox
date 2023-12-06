CREATE TABLE genres(
   id          BIGINT AUTO_INCREMENT PRIMARY KEY,
   description VARCHAR(255) NOT NULL
);

CREATE TABLE movies(
   id        BIGINT AUTO_INCREMENT PRIMARY KEY,
   name      VARCHAR(255) NOT NULL,
   genre_id  BIGINT       NOT NULL,
   watchlist BOOL         NOT NULL,

   FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE watched(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id  BIGINT       NOT NULL,
    rating    SMALLINT     NOT NULL,
    remark    VARCHAR(255) NOT NULL,
    favorite  BOOL         NOT NULL DEFAULT FALSE,

    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE TABLE streamings(
   id   BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(255) NOT NULL
);

CREATE TABLE movie_streaming(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id      BIGINT NOT NULL,
    streaming_id  BIGINT NOT NULL,
    rentable      BOOL   NOT NULL DEFAULT FALSE,

    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (streaming_id) REFERENCES streamings(id)
);

INSERT INTO genres (description) VALUES ('Ação');
INSERT INTO genres (description) VALUES ('Aventura');
INSERT INTO genres (description) VALUES ('Animação');
INSERT INTO genres (description) VALUES ('Comédia');
INSERT INTO genres (description) VALUES ('Crime');
INSERT INTO genres (description) VALUES ('Documentário');
INSERT INTO genres (description) VALUES ('Drama');
INSERT INTO genres (description) VALUES ('Família');
INSERT INTO genres (description) VALUES ('Fantasia');
INSERT INTO genres (description) VALUES ('História');
INSERT INTO genres (description) VALUES ('Horror');
INSERT INTO genres (description) VALUES ('Música');
INSERT INTO genres (description) VALUES ('Mistério');
INSERT INTO genres (description) VALUES ('Romance');
INSERT INTO genres (description) VALUES ('Ficção científica');
INSERT INTO genres (description) VALUES ('Guerra');
INSERT INTO genres (description) VALUES ('Ocidental');

INSERT INTO streamings (name) VALUES ('Prime Video');
INSERT INTO streamings (name) VALUES ('Crunchyroll');
INSERT INTO streamings (name) VALUES ('Disney+');
INSERT INTO streamings (name) VALUES ('HBO Go');
INSERT INTO streamings (name) VALUES ('Netflix');