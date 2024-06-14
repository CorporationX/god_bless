package faang.school.godbless.train_stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util {
    private static final List<Integer> NUMBERS = List.of(2, 6, 5, 9, 12, 15, 3, 65, 41, 50, 72);
    private static final List<String> STRINGS = List.of("Hello", "OK", "", "Good Bye", "Bye", "Hi", "You are welcome");

    public static void main(String[] args) {
        System.out.println(sumEvenNumbers(NUMBERS));
        System.out.println(max(NUMBERS));
        System.out.println(average(NUMBERS));
        System.out.println(countStringBeginWith(STRINGS, 'O'));
        filterStrings(STRINGS, "Bye").stream().forEach(System.out::println);
        sortedStringsByLength(STRINGS).stream().forEach(System.out::println);
        System.out.println(checkAllMatch(NUMBERS, x -> x < 100));
        System.out.println(checkAllMatch(STRINGS,str -> str.length() < 25));
        System.out.println(checkAllMatch(STRINGS,str -> str.length() != 0));
        System.out.println(findMinWhichMoreNum(NUMBERS,12));
        transformStrInLengthStr(STRINGS).stream().forEach(System.out::println);
    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        checkListIsEmpty(numbers);
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static int max(List<Integer> numbers) {
        checkListIsEmpty(numbers);
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    public static int average(List<Integer> numbers) {
        checkListIsEmpty(numbers);
        return (int) numbers.stream().mapToInt(num -> num).average().orElseThrow();
    }

    public static int countStringBeginWith(List<String> strings, char symbol) {
        checkListIsEmpty(strings);
        return (int) strings.stream().filter(str -> !str.isBlank()).filter(str -> str.charAt(0) == symbol).count();
    }

    public static List<String> filterStrings(List<String> strings, String substring) {
        checkListIsEmpty(strings);
        return strings.stream().filter(str -> !str.isBlank()).filter(str -> str.contains(substring)).toList();
    }

    public static List<String> sortedStringsByLength(List<String> strings) {
        checkListIsEmpty(strings);
        return strings.stream().filter(str -> !str.isEmpty()).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static  <T> boolean checkAllMatch(List<T> list, Predicate<T> predicate){
        checkListIsEmpty(list);
        return list.stream().allMatch(predicate);
    }

    public static int findMinWhichMoreNum(List<Integer> numbers, int num){
        checkListIsEmpty(numbers);
        return numbers.stream().filter(n -> n > num).min(Comparator.comparingInt(a -> a)).orElseThrow();
    }

    public static List<Integer> transformStrInLengthStr(List<String> strings){
        checkListIsEmpty(strings);
        return strings.stream().map(s -> s.length()).collect(Collectors.toList());
    }

    private static <T> void checkListIsEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }
}
