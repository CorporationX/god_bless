package faang.school.godbless.secondSprint.JobAnalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        String json = "{\"position\":\"bezdelnik\",\"requirements\":[\"pit' pivo\"], \"salary\":\"100500\"," +
                " \"location\":\"Lentyaevo\", \"date\":\"2023-06-22T12:34:56\"}";
        String json1 = "{\"position\":\"lentyai\",\"requirements\":[\"lezhat' na divane\"], \"salary\":\"100501\"," +
                " \"location\":\"Lentyaevo\", \"date\":\"2023-06-22T12:34:56\"}";

        System.out.println(dataAnalyzer.findMostPopularPosition(Stream.of(json, json1)));
        System.out.println(dataAnalyzer.findMostPopularSkills(Stream.of(json, json1)));
        System.out.println(dataAnalyzer.getSalaryDistribution(Stream.of(json, json1)));
        System.out.println(dataAnalyzer.findMostPopularLocation(Stream.of(json, json1)));
    }
}
