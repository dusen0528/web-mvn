package com.nhnacademy;

public class Movie {
    private final long movieId;
    private final String title;
    private final String[] genres;

    public Movie(long movieId, String title, String genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres.split("\\|"); // genres를 | 기준으로 분리
    }

    public long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String[] getGenres() {
        return genres.clone(); // 배열의 방어적 복사
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genres=" + String.join("|", genres) +
                '}';
    }
}