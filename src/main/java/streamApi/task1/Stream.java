package streamApi.task1;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static int evenSum(List<Integer> numbers) {
        int evenSum = numbers.stream()
                .filter((number) -> number % 2 == 0)
                .reduce(0, (number1, number2) -> number1 + number2);
        return evenSum;
    }

    public static int max(List<Integer> numbers) {
        Integer max = numbers.stream()
                .max((numbers1, numbers2) -> numbers1 - numbers2)
                .get();
        return max;
    }

    public static double average(List<Integer> numbers) {
        double average = numbers.stream()
                .mapToDouble(number -> number)
                .average()
                .getAsDouble();
        return average;
    }

    public static long countString(char start, List<String> strings) {
        long countString = strings.stream()
                .filter((string) -> string.startsWith(String.valueOf(start)))
                .count();
        return countString;
    }

    public static List<String> getSubstringList(String substring, List<String> strings) {
        List<String> filterStrings = strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
        return filterStrings;
    }

    public static void sortedList(List<String> strings) {
        strings.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .forEach(str -> System.out.println(str));
    }

    public static boolean anyMatch(List<String> strings) {
        boolean checkElement = strings.stream().allMatch(string -> string.length() > 5);
        return checkElement;
    }

    public static int specialMin(int number, List<Integer> numbers) {
        Integer min = numbers.stream()
                .filter(num -> num > number)
                .min((num1, num2) -> num1 - num2)
                .get();
        return min;
    }

    public static List<Integer> transformer(List<String> strings) {
        List<Integer> sheetLengths = strings.stream()
                .map(str -> str.length())
                .toList();
        return sheetLengths;
    }
}
