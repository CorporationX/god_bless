package streamAPI_1_915;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamTest1 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 10);

        System.out.println("Сумма четных чисел = " + sumEvenNumbers(numbers));
        System.out.println("Максимальное число = " + getMaxNumber(numbers));
        System.out.println("Среднее число = " + getAverageNumber(numbers));
        System.out.println("Среднее число = " + getAverageNumber1(numbers));

        List<String> words = Arrays.asList("Cat", "Dog's home", "Candy", "Baby's home");
        System.out.println("Количество слов на букву С = " + countWords(words));
        System.out.println("Новый список: " + sortFilterWords(words));
        System.out.println("Новый список: " + sortByLength(words));

        System.out.println("Все элементы прошли по условию - " + checkCondition(words));
        System.out.println("Наименьшее число больше 4 = " + getMinNum(numbers));
        System.out.println("Список длин строк: " + fillListLength(words));

    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter((num) -> num % 2 == 0)
                .sum();
    }

    // 2 вариант
    public static int sumEvenNumbers1(List<Integer> numbers) {
        return numbers.stream()
                .filter((num) -> num % 2 == 0)
                .reduce(0, (a, b) -> a + b);
    }

    // 1 вариант getMaxNumber
    public static int getMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    // 2 вариант getMaxNumber
    public static int getMaxNumber1(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    // 1 вариант расчета getAverageNumber
    public static int getAverageNumber(List<Integer> numbers) {
        return (int) numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    //  2 вариант расчета getAverageNumber
    public static int getAverageNumber1(List<Integer> numbers) {
        return (int) numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    // 3 вариант расчета getAverageNumber
    public static int getAverageNumber2(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (a, b) -> (a + b)) / numbers.size();
    }

    public static long countWords(List<String> words) {
        return words.stream()
                .filter((word) -> word.substring(0, 1).equals("C"))
                .count();
    }

    public static List<String> sortFilterWords(List<String> words) {
        return words.stream()
                .filter((word) -> word.contains("home"))
                .sorted()
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean checkCondition(List<String> words) {
        return words.stream()
                .allMatch((a) -> a.length() < 20);
    }

    public static int getMinNum(List<Integer> numbers) {
        return numbers.stream()
                .filter((a) -> a > 4)
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }

    public static List<Integer> fillListLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}