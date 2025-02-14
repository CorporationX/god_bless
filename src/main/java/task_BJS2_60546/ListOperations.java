package task_BJS2_60546;

import java.util.List;

public class ListOperations {

    public static int getMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .max()
                .orElseThrow(() -> new NullPointerException("Список пуст"));
    }

    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static double getAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(number -> number)
                .average()
                .orElseThrow(() -> new NullPointerException("Список пуст"));
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }


}
