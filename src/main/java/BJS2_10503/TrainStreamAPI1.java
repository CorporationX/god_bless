package BJS2_10503;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainStreamAPI1 {

    public static void arrPrint(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> System.out.print(number + "  "));
    }

    public static int numbersSum(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> (int) number)
                .sum();
    }

    public static int numbersMax(List<Integer> numbers) {
        return numbers.stream()
                .max((n1, n2) -> n1 - n2)
                .orElse(null);
    }

    public static double numbersAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .average()
                .getAsDouble();
    }

    public static int numbersMinX(List<Integer> numbers, int x) {
        return numbers.stream()
                .filter(number -> number > x)
                .min((n1, n2) -> n1 - n2)
                .orElse(null);
    }

    public static int stringCount(List<String> countries, String a) {
        return (int) countries.stream()
                .filter(country -> country.startsWith(a))
                .count();
    }

    public static int strContainsSub(List<String> countries, String a) {
        return (int) countries.stream()
                .filter(country -> country.contains("n"))
                .count();
    }

    public static List<String> strContainsSubList(List<String> countries, String a) {
        return countries.stream()
                .filter(country -> country.contains(a))
                .collect(Collectors.toList());
    }

    public static void stringSort(List<String> countries) {
        countries.stream()
                .sorted((country1, country2) -> country1.length() - country2.length())
                .forEach(country -> System.out.print(country + " "));
    }

    public static boolean stringPredict(List<String> countries) {
        return countries.stream()
                .allMatch((country) -> country.length() > 4);
    }

    public static void stringToLength(List<String> countries) {
        countries.stream()
                .map(String::length)
                .toList()
                .forEach(country -> System.out.print(country + " "));
    }

    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        arrPrint(numbers);
        System.out.println("\nМаксимальный элемент в списке: " + numbersMax(numbers));
        System.out.println("Сумма четных чисел в списке: " + numbersSum(numbers));
        System.out.println("Среднее значение чисел в списке: " + numbersAverage(numbers));
        System.out.println("Найти наименьший элемент в списке, который больше заданного числа (50): " + numbersMinX(numbers, 50));

        ArrayList<String> countries = new ArrayList<>();
        countries.add("australia");
        countries.add("brazil");
        countries.add("italy");
        countries.add("france");
        countries.add("germany");
        countries.add("argentina");
        System.out.println("Список строк: " + countries);
        System.out.println("Количество строк, начинающихся с символа \"а\": " + stringCount(countries, "a"));
        System.out.println("Количество строк, содержащих подстроку \"n\": " + strContainsSub(countries, "n"));
        System.out.println("Строки, содержащие подстроку \"n\": " + strContainsSubList(countries, "n"));
        System.out.println("Отсортировать список строк по длине: ");
        stringSort(countries);
        System.out.println("\nПроверить, все ли элементы списка удовлетворяют определённому условию: в строке больше 4 элементов -" + stringPredict(countries));
        System.out.println("Преобразовать список строк в список их длин: ");
        stringToLength(countries);
    }
}

