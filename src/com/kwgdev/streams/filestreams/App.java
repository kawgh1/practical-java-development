package com.kwgdev.streams.filestreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {

        Stream<String> lines = Files.lines(Paths.get("src/com/kwgdev/streams/filestreams/wordFile.txt"));

        lines
                .filter((l -> l.length() > 6)) // return words longer than 6 letters
                .sorted()
                .forEach(x -> System.out.println(x + ", "));
        // close your files!
        lines.close();

        System.out.println("\n new stream \n");

        // new stream - can only do operations on a stream once it has returned
        Stream<String> words = Files.lines(Paths.get("src/com/kwgdev/streams/filestreams/wordFile.txt"));

        words
                .filter((x -> x.contains("th")))
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x + ", "));
        // close your files!
        words.close();

        System.out.println("\n new stream \n");

        Stream<String> rows = Files.lines(Paths.get("src/com/kwgdev/streams/filestreams/stockDataCsv.txt"));

        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x -> x.length > 3) // filter on rows that have more than 3 elements
                .count();
        System.out.println(rowCount + " good rows");
        rows.close();


        System.out.println("\n new stream \n");

        Stream<String> rows2 = Files.lines(Paths.get("src/com/kwgdev/streams/filestreams/stockDataCsv.txt"));

        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length > 3) // filter for rows with > 3 elements
                .filter(x -> Integer.parseInt(x[1].trim()) > 15) // filter rows if 2nd element > 15
                .forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3].trim()));
        rows2.close();
    }
}
