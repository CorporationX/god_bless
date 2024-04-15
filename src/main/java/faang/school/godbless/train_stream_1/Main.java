package faang.school.godbless.train_stream_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Сумма чётных чисел: " + sum);

        Optional<Integer> maxValue = numbers.stream().max(Integer::compare);
        System.out.println("Наибольшее число в списке: " + maxValue);

        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println("Среднее значение: " + average);

        List<String> strings = Arrays.asList("Onboarding", "Stream", "Java", "Sql", "System", "Swimming");
        long count = strings.stream().filter(s -> s.startsWith("S")).count();
        System.out.println("Слов на букву S: " + count);

        List<String> filteredStrings = strings.stream().filter(f -> f.contains("ing")).toList();
        System.out.println("Слова заканчивающиеся на ing: " + filteredStrings);

        List<String> sizeStrings = strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println("Список слов по длине: " + sizeStrings);

        boolean startsWithJ = strings.stream().allMatch(s -> s.startsWith("J"));
        System.out.println("Все ли слова начинаются на букву J: " + startsWithJ);
        List<String> names = Arrays.asList("Mark", "Mick", "Molly");
        boolean startsWithM = names.stream().allMatch(s -> s.startsWith("M"));
        System.out.println("Все ли имена начинаются на букву M: " + startsWithM);

        OptionalInt number = numbers.stream().filter(n -> n > 8).mapToInt(Integer::intValue).min();
        System.out.println("Минимальное число больше чем 8: " + number);

        List<Integer> lengths = strings.stream().map(String::length).toList();
        System.out.println("Длины строк: " + lengths);
    }
}

