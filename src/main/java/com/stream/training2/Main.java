package com.stream.training2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 9, 3, 6, 4, 5);
        int number = 10;
        System.out.println(Stream.searchUniquePairs(numberList, number));
        System.out.println();

        Map<String, String> country = new HashMap<>();
        country.put("Russia", "Moscow");
        country.put("Belarus", "Minsk");

        System.out.println(Stream.getСapital(country));
        System.out.println();

        List<String> linesList = List.of("I am studying at a bootcamp",
                "I work on the railroad",
                "There's no point in saying anything.");
        char word = 'I';

        System.out.println(Stream.getLines(linesList, word));
        System.out.println();

        Map<String, List<String>> friends = new HashMap<>();

        friends.put("Petr", List.of("Denis", "Jenya", "Vasiliy"));
        friends.put("Viktor", List.of("Misha", "Denis", "Gena"));
        friends.put("Sveta", List.of("Misha", "Denis", "Olga"));
        friends.put("Anna", List.of("Kesha"));

        System.out.println(Stream.getPair(friends));
        System.out.println();

        List<Employee> employeeList = List.of(new Employee("Ivan", 10_000.0, "Accounting"),
                new Employee("Dima", 20_000.0, "Accounting"),
                new Employee("Sveta", 30_000.0, "Accounting"),
                new Employee("Luda", 31_000.0, "Personnel"),
                new Employee("Irina", 29_000.0, "Personnel"),
                new Employee("Elena", 39_000.0, "Personnel"));

        System.out.println(Stream.getAvgSalaryByDepartment(employeeList));
        System.out.println();

        List<String> lines = List.of("apple", "banana", "123", "dog", "cat");
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        System.out.println(Stream.filterLinesByAlphabet(lines, alphabet));
        System.out.println();

        String text = "Hello bootcamp";
        Stream.convert(convertByBinaryCode(text)).forEach(System.out::print);

    }

    // Метод, который преобразует строку в двоичный код и возвращает массив с разделением по сплиту
    public static String[] convertByBinaryCode(String text) {
        byte[] bytes = text.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        return binary.toString().split("\\s");
    }

}
