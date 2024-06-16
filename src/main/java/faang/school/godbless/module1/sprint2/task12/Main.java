package faang.school.godbless.module1.sprint2.task12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(4, 9, -5, 15, 2, 3, 4, 1);
        List<String> stringList = List.of("one", "two", "three", "four", "five", "123abc");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("Albania", "Tirane");
        countries.put("Australia", "Sydney");
        countries.put("England", "London");
        countries.put("USA", "New York");
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Ali", List.of("Iton", "Bob", "Alan"));
        friends.put("Kate", List.of("Mile", "Bob", "Alan"));
        friends.put("Jon", List.of("Philip", "Nestor", "Alex"));
        System.out.println(foundSumInMapByNum(integerList, 5));
        System.out.println(foundSumInListByNum(integerList, 5));
        printAllCapitals(countries);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Fedor", 18000, "Driver"));
        employees.add(new Employee("Max", 40000, "Driver"));
        employees.add(new Employee("Jax", 50000, "Builders"));
        employees.add(new Employee("Yana", 45000, "Builders"));
        System.out.println(filterListStringByChar(stringList, 't'));
        System.out.println(getSalaryByDepartment(employees));
        System.out.println(sortListByCharArray(stringList, alphabet));
        System.out.println(foundPairFriends(friends));
        System.out.println(integerToSting(integerList));
        System.out.println(searchPalindrome(-55, 555));
    }

    //Не совсем понял задание, оставил оба варианта решения для первой части
    public static Map<Integer, Integer> foundSumInMapByNum(List<Integer> integerList, Integer number) {
        return integerList.stream()
                .flatMap(l -> integerList.stream()
                        .filter(j -> l + j == number))
                .distinct()
                .collect(Collectors.toMap(l -> l, j -> number - j));

    }

    //Не совсем понял задание, оставил оба варианта решения для первой части
    public static List<Integer> foundSumInListByNum(List<Integer> integerList, Integer number) {
        return integerList.stream()
                .flatMap(l -> integerList.stream()
                        .filter(j -> l + j == number))
                .distinct()
                .toList();
    }

    public static void printAllCapitals(Map<String, String> capitals) {
        List<String> listOfCapitals = capitals
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
        listOfCapitals.forEach(l -> System.out.print(l + " "));
    }

    public static List<String> filterListStringByChar(List<String> strings, Character ch) {
        return strings.stream()
                .filter(l -> l.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> foundPairFriends(Map<String, List<String>> friends) {
        return friends.entrySet()
                .stream()
                .flatMap(person1 -> friends.entrySet().stream()
                        .filter(person2 -> !person2.getKey().equals(person1.getKey()))
                        .filter(person2 -> !person1.getValue().contains(person2.getKey()))
                        .filter(person2 -> person1.getValue().stream()
                                .anyMatch(person2.getValue()::contains))
                        .map(person2 -> {
                            String nameFirst = person1.getKey();
                            String nameSecond = person2.getKey();
                            if (nameFirst.compareTo(nameSecond) < 0) {
                                return nameFirst + " " + nameSecond;
                            } else {
                                return nameSecond + " " + nameFirst;
                            }
                        }))
                .distinct()
                .toList();

    }


    public static Map<String, Double> getSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.averagingInt((Employee::getSalary))));
    }

    public static List<String> sortListByCharArray(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> IntStream.range(0, string.length())
                        .allMatch(index -> alphabet.indexOf(string.charAt(index)) != -1))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> integerToSting(List<Integer> integerList) {
        return integerList.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> searchPalindrome(int firstValue, int secondValue) {
        IntStream streamOfInt = IntStream.range(firstValue, secondValue);
        return streamOfInt
                .filter(number -> String.valueOf(Math.abs(number)).contentEquals(new StringBuilder(String.valueOf(number)).reverse()))
                .boxed().toList();
    }


}
