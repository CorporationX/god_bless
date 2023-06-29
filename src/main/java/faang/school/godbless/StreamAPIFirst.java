package faang.school.godbless;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamAPIFirst {
    public static int sumEvenNumbers(List<Integer> numbers){
        validateList(numbers);
        return numbers.stream()
                .filter(number -> number%2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findMaxElement(List<Integer> numbers){
        validateList(numbers);
        return numbers.stream()
                .max(Comparator.comparingInt(integer -> integer))
                .orElse(0);
    }

    public static double findAverageValue(List<Integer> numbers){
        validateList(numbers);
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static int countLinesStartsWith(List<String> lines, String a){
        validateList(lines);
        return (int) lines.stream()
                .filter(line -> line.startsWith(a)).count();
    }

    public static List<String> filteredList (List<String> words, String substring){
        validateList(words);
        return words.stream()
                .filter(x -> x.equals(substring))
                .toList();
    }

    public static List<String> lengthFiltered (List<String> words){
        validateList(words);
        return words.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static <T> boolean checkAllElements(List<T> numbers, Predicate<T> predicate){
        validateList(numbers);
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinMoreThan(List<Integer> numbers, int someNumber){
        validateList(numbers);
        return numbers.stream()
                .filter(number -> number > someNumber).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> stringsToLength(List<String> words){
        validateList(words);
        return words.stream()
                .map(String::length)
                .toList();
    }

    public static <T> void validateList(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException("List is empty!");
        }
    }

}
