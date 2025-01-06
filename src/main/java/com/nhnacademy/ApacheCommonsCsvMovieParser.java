package com.nhnacademy;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movies = new ArrayList<>();

        try (Reader reader = new InputStreamReader(getMovieFileAsStream());
             CSVParser csvParser = CSVFormat.DEFAULT
                     .withFirstRecordAsHeader() // 첫 줄을 헤더로 처리
                     .withIgnoreHeaderCase()    // 헤더 대소문자 무시
                     .withTrim()                // 값의 앞뒤 공백 제거
                     .parse(reader)) {

            for (CSVRecord record : csvParser) {
                Movie movie = new Movie(
                        Long.parseLong(record.get(0)),  // movieId
                        record.get(1),                  // title
                        record.get(2)                   // genres
                );
                movies.add(movie);
            }
        }

        return movies;
    }
}