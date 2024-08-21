package stream.api1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "cherry", "apricot", "blueberry");

        System.out.println("Сумма чётныйх элементов: " + sumEvenNumbers(numbers));
        System.out.println("Максимальный элементов: " + maxNumber(numbers));
        System.out.println("Среднее значение элементов: " + avgNumber(numbers).getAsDouble());

        char startedChar = 'a';
        long count = strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startedChar)))
                .count();

        System.out.println("Количество строк, начинающихся с '" + startedChar + "': " + count);
        String sub = "rry";

        List<String> filteredStrings = strings.stream()
                .filter(s -> s.contains(sub))
                .toList();

        System.out.println("Строки, содержащие подстроку '" + sub + "': " + filteredStrings);

        List<String> sortedStrings = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println("Строки, отсортированные по длине: " + sortedStrings);

        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);

        if (allEven) {
            System.out.println("Все элементы списка четные.");
        } else {
            System.out.println("Не все элементы списка четные.");
        }

        int bigNumber = 1;

        Optional<Integer> minGreaterThanTarget = numbers.stream()
                .filter(num -> num > bigNumber)
                .min(Integer::compareTo);

        if (minGreaterThanTarget.isPresent()) {
            System.out.println("Наименьший элемент, который больше " + bigNumber + ": " + minGreaterThanTarget.get());
        } else {
            System.out.println("Нет элементов, которые больше " + bigNumber);
        }

        List<Integer> lengths = strings.stream()
                .map(String::length)
                .toList();

        System.out.println("Список длин строк: " + lengths);
    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter((num) -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static Integer maxNumber(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparingInt(n -> n)).get();
    }

    public static OptionalDouble avgNumber(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average();
    }
}

