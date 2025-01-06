package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

public class BasicMovieParser implements MovieParser {
    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movies = new ArrayList<>();

        try(InputStream inputStream = getMovieFileAsStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){

            reader.readLine(); // 첫줄 헤더

            String line;
            while((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if(fields.length >= 3) {
                    Movie movie = new Movie(
                            Integer.parseInt(fields[0].trim()),
                            fields[1].trim(),
                            fields[2].trim()
                    );
                    movies.add(movie); // 누락된 부분 추가
                }
            }
        }
        return movies;
    }

    @Override
    public InputStream getMovieFileAsStream() {
        return MovieParser.super.getMovieFileAsStream(); // 캐스팅 제거
    }
}
