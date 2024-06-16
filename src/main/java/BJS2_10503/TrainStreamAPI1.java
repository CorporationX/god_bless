package BJS2_10503;

import java.util.ArrayList;
import java.util.List;

public class TrainStreamAPI1 {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        numbers.stream()
                .forEach(number -> System.out.print(number + "  "));

        System.out.println("\nСумма четных чисел в списке: "
                + numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum()
        );
        System.out.println("Максимальный элемент в списке: "
                + numbers.stream()
                .max((n1, n2) -> n1-n2)
                .orElse(null)
        );
        System.out.println("Среднее значение чисел в списке: "
                + numbers.stream()
                .mapToInt(number -> number)
                .average()
                .getAsDouble()
        );
        System.out.println("Найти наименьший элемент в списке, который больше заданного числа (50): "
                + numbers.stream()
                .filter(number -> number > 50)
                .min((n1, n2) -> n1-n2)
                .orElse(null)
        );
        ArrayList<String> countries = new ArrayList<>();
        countries.add("australia");
        countries.add("brazil");
        countries.add("italy");
        countries.add("france");
        countries.add("germany");
        countries.add("argentina");
        System.out.println("Список строк: "+ countries);
        System.out.println("Количество строк, начинающихся с символа \"a\": "
                + countries.stream()
                .filter(country-> country.startsWith("a"))
                .count()
                );
        System.out.println("Количество строк, содержащих подстроку \"n\": "
                + countries.stream()
                .filter(country-> country.contains("n"))
                .count()
        );
        System.out.println("Строки, содержащие подстроку \"l\": ");
        countries.stream()
                .filter(country-> country.contains("l"))
                .forEach(country -> System.out.print(country + " "));
        System.out.println("\nОтсортировать список строк по длине: ");
        countries.stream()
                .sorted((country1, country2) -> country1.length()-country2.length())
                .forEach(country -> System.out.print(country + " "));
        System.out.println("\nПроверить, все ли элементы списка удовлетворяют определённому условию: в строке больше 4 элементов - "+ countries.stream()
                .allMatch((country) -> country.length() > 4)
        );
        System.out.println("Преобразовать список строк в список их длин: ");
        countries.stream()
                .map(String::length)
                .toList()
                .forEach(country -> System.out.print(country + " "));
    }
}
