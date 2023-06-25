package faang.school.godbless.trainingStreamAPI1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TrainingStreamFirst {
    private static final Runnable listError = () -> System.out.println("Переданный список пуст!");

    //сумма четных чисел в списке
    public static int getSumEvenNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            listError.run();
            return 0;
        }
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    //максимальный элемент в списке чисел
    public static int getMaxNumber(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            listError.run();
            return 0;
        }
        return numbers.stream()
                .max(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);
    }

    //среднее значение чисел в списке
    public static double getAverageOfNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            listError.run();
            return 0;
        }
        //return numbers.stream().mapToInt((number) -> number).average().orElse(0.0);
        //этот вариант вроде должен быть быстрее, так как не будет доп преобразования к массиву
        return numbers.stream()
                .reduce(0, Integer::sum) / (double) numbers.size();
    }

    //количество строк, начинающихся с определённого символа в списке строк
    public static long getNumberOfStringStartingWithCharacter(List<String> strings, char c) {
        if (strings == null || strings.isEmpty()) {
            listError.run();
            return 0;
        }
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(c)))
                .count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    public static List<String> getStringListContainsSubstring(List<String> strings, String substring) {
        if (strings == null || strings.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }
        if (substring == null || substring.isEmpty()) {
            System.out.println("Подстрока пустая!");
            return new ArrayList<>();
        }
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    //Отсортировать список строк по длине;
    public static List<String> sortStringListByLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static <T> boolean isAllElementsMatch(List<T> list, Predicate<T> predicate) {
        if (list == null || list.isEmpty()) {
            listError.run();
            return false;
        }
        if (predicate == null) {
            System.out.println("Условие не задано");
            return false;
        }
        return list.stream()
                .allMatch(predicate);
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static int getMinBiggerThanGiven(List<Integer> numbers, int given) {
        if (numbers == null || numbers.isEmpty()) {
            listError.run();
            return given;
        }

        return numbers.stream()
                .filter(number -> number > given)
                .min(Comparator.naturalOrder()).orElse(given);
    }

    //Преобразовать список строк в список их длин
    public static List<Integer> getLengthOfStringsList(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            listError.run();
            return new ArrayList<>();
        }

        return strings.stream()
                .map(String::length)
                .toList();
    }

    public static void main(String[] args) {
        List<String> strings = List.of("hello", "world1", "konta", "Bob");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //сумма четных чисел в списке
        System.out.println("Сумма четных: " + getSumEvenNumbers(numbers));

        //максимальный элемент в списке чисел
        System.out.println("Максимальный элемент: " + getMaxNumber(numbers));

        //среднее значение чисел в списке
        System.out.println("Среднее значение: " + getAverageOfNumbers(numbers));

        //количество строк, начинающихся с определённого символа в списке строк
        System.out.println("Начинаются с определённого символа: " + getNumberOfStringStartingWithCharacter(strings, 'h'));

        //Отфильтровать список строк
        System.out.println("Отфильтровать список строк: ");
        getStringListContainsSubstring(strings, "ell").forEach((str) -> System.out.print(str + " "));
        System.out.println();

        //Отсортировать список строк по длине
        System.out.println("Отсортировать список строк по длине:");
        sortStringListByLength(strings).forEach((str) -> System.out.print(str + " "));
        System.out.println();

        //Проверить, все ли элементы списка удовлетворяют определённому условию
        System.out.println("Проверка элементов: " + isAllElementsMatch(numbers, (number) -> number > 2));

        //Найти наименьший элемент в списке, который больше заданного числа
        System.out.println("Наименьший элемент больше заданного: " + getMinBiggerThanGiven(numbers, 3));

        //Преобразовать список строк в список их длин
        System.out.println("Список длин:");
        getLengthOfStringsList(strings).forEach((length) -> System.out.print(length + " "));
    }
}
