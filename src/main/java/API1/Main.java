package API1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void method(List<Integer> integerList) {
        List<String> collect = integerList.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static List<Integer> findPolendroms(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(i -> String.valueOf(i).contentEquals(new StringBuilder(String.valueOf(i)).reverse()))
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, 9, 3, 6, 4, 5);
        int tgsum = 10;
        Map<Integer, Integer> pairValues = integerList.stream()
                .filter(num -> integerList.contains(tgsum - num) && num < tgsum - num)
                .collect(Collectors.toMap(
                        num -> num,
                        num -> tgsum - num
                ));
        pairValues.forEach((key, value) -> System.out.println("[" + key + "," + value + "]"));
        System.out.println("_________________________________________________________________");
        Map<String, String> countryCapitalMap = new java.util.HashMap<>();
        countryCapitalMap.put("Germany", "Berlin");
        countryCapitalMap.put("Italy", "Rome");
        countryCapitalMap.put("Spain", "Madrid");
        countryCapitalMap.put("Japan", "Tokyo");
        List<String> capitals = countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(capitals);
        System.out.println("_________________________________________________________________");
        List<String> stringList = Arrays.asList("gsd", "asdasf", "dsasaf", "asdaf", "gasfg", "ddhd");
        char letter = 'd';
        List<String> fs = stringList.stream()
                .filter(s -> s.charAt(0) == letter)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(fs);
        System.out.println("_________________________________________________________________");
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Sasha", Arrays.asList("Masha", "Gena", "Vanya"));
        friendsMap.put("Petya", Arrays.asList("Anya", "Gena"));
        friendsMap.put("Vanya", Arrays.asList("Anya", "Sasha"));
        friendsMap.put("Anya", Arrays.asList("Petya", "Gena"));
        friendsMap.put("Masha", Arrays.asList("Sasha", "Petya"));
        friendsMap.put("Gena", Arrays.asList("Masha", "Petya"));
        Set<String> commonFriends = friendsMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .flatMap(friend -> friendsMap.get(friend).stream()
                                .filter(f -> !entry.getValue().contains(f) && !f.equals(entry.getKey()))
                                .map(f -> entry.getKey() + " - " + f)))
                .collect(Collectors.toSet());
        commonFriends.forEach(System.out::println);
        System.out.println("_________________________________________________________________");
        List<Employee> employees = Arrays.asList(
                new Employee("Sasha", 99999.0, "yomto"),
                new Employee("Vanya", 88888.0, "mvd"),
                new Employee("Gena", 77777.0, "rjd"));
        Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getOtdel,
                        Collectors.averagingDouble(Employee::getZp)));
        map.forEach((otdel, sredniezp) -> System.out.println(otdel + ":" + sredniezp));
        System.out.println("_________________________________________________________________");
        List<String> strings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> filter = strings.stream()
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .filter(s -> s.chars().allMatch(c -> Arrays.binarySearch(alphabet, (char) Character.toLowerCase(c)) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(filter);
        System.out.println("_________________________________________________________________");
        method(integerList);
        System.out.println("_________________________________________________________________");
        List<Integer> palindromes = findPolendroms(100, 150);
        System.out.println(palindromes);
        System.out.println("_________________________________________________________________");
    }
}