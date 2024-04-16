package faang.school.godbless.BJS2_5434;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 5, 6, 10);
        List<String> words = List.of("LOL", "Akali", "HORSE", "LEONA", "leopard");

        System.out.printf("Сумма четных чисел в списке: %d %n", evenNums(nums));
        System.out.printf("Максимальный элемент списка: %d %n", getMax(nums));
        System.out.printf("Среднее значение в списке: %f %n", getAverage(nums));
        System.out.printf("Количество строк, начинающихся с определенного символа: %d %n", countWords(words, 'a'));
        System.out.printf("Строки, содержащие определенную подстроку: %s %n", filterWordsContainsSubstring(words, "LEO"));
        System.out.printf("Сортировка строк по длине: %s %n", String.join(" ", sortedWordsByLength(words)));
        System.out.printf("Все ли элементы удовлетворяют условию: %b %n", checkConditional(nums, num -> num > 5));
        System.out.printf("Минимальный элемент, больше заданного: %d %n", findMinThanBigger(nums, 5));
        System.out.printf("Список длин строк: %s %n", getListLength(words).toString());

    }

    public static int evenNums(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMax(List<Integer> nums) {
        OptionalInt optionalInt = nums.stream()
                .mapToInt(num -> num)
                .max();
        return optionalInt.orElse(0);
    }

    public static double getAverage(List<Integer> nums) {
        OptionalDouble optionalDouble = nums.stream().mapToDouble(Integer::doubleValue).average();
        return optionalDouble.orElseThrow(() -> new RuntimeException("List is null"));
    }

    public static int countWords(List<String> words, Character ch) {
        return (int) words.stream()
                .filter(word -> word.toLowerCase().charAt(0) == Character.toLowerCase(ch))
                .count();
    }

    public static List<String> filterWordsContainsSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.toLowerCase()
                        .contains(substring.toLowerCase()))
                .toList();
    }

    public static List<String> sortedWordsByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean checkConditional(List<Integer> nums, Predicate<Integer> conditional) {
        return nums.stream()
                .allMatch(conditional);
    }

    public static int findMinThanBigger(List<Integer> nums, int number) {
        Optional<Integer> opt = nums.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo);
        return opt.orElseThrow(() -> new RuntimeException("Такого элемента нет"));
    }

    public static List<Integer> getListLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }


}
