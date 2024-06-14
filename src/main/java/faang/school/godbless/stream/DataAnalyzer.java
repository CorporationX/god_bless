package faang.school.godbless.stream;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    //метод, который выводит топ-5 самые популярные скиллы для кандидата
    public static List<String> getRequiredSkills(@NonNull List<Job> jobList) {
        return jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    //метод, который выводит список наиболее популярных названий позиций (от самых популярных до наименее популярных)
    // Также стоит задать лимит на количество возвращаемых значений, например вывести 5 самых популярных;

    public static List<String> getPopularPositions(@NonNull List<Job> jobList) {
        return jobList.stream()
                .map(Job::getPosition)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    //метод, который анализирует распределение зарплат по вакансиям и возвращает структуру данных, содержащую информацию
    // о распределении зарплат по различным диапазонам (например, 0-50k, 50k-100k, 100k-150k и т.д.) и
    // количеству вакансий, которые соответствуют этим диапазонам;

    public static Map<List<String>, Long> getSalaryDistribution(@NonNull List<Job> jobList) {
        return jobList.stream()
                .map(Job::getSalary)
                .collect(Collectors.groupingBy(salary -> salary, Collectors.mapping(DataAnalyzer::getRange, Collectors.toList())))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()));
    }

    private static String getRange(Double number) {
        long round = Math.round(number);
        while (round % 50 != 0) {
            round--;
        }
        return round + "-" + (round + 50);
    }

    //метод, который возвращает 5 наиболее популярных местоположений офисов;
    public static List<String> getPopularLocations(@NonNull List<Job> jobList) {
        return jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}

