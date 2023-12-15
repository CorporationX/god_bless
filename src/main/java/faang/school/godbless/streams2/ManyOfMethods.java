package faang.school.godbless.streams2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManyOfMethods {
    public static List<List<Integer>> findPairs(List<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(number -> numbers.stream()
                        .filter(number1 -> !number.equals(number1) && number + number1 == targetSum&&number.compareTo(number1)<0)
                        .map(filterNumb -> Arrays.asList(number, filterNumb)))
                .distinct() // жесть просто... На один этот метод я потратил часа 2,он работает, но не понимаю все равно
                .toList(); // P/s потратил еще полчаса,что бы понять. Понял,только когда в одну строчку все посмотрел(может и неправильно)
    }

    public static void capitals(Map<String, String> countriesWithCapitals) {
        countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList()
                .forEach(System.out::println);

    }

    public static List<String> sortStrings(List<String> strings, char specialShar) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(specialShar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();//(stringFirst,stringSecond)->Integer.compare(stringFirst.length(),stringSecond.length())

    }

    public static List<List<String>> pairOfPeople(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(person -> friends.entrySet().stream()
                        .filter(person1 -> !person1.getKey().equals(person.getKey())
                                && person1.getKey().compareTo(person.getKey()) < 0
                                && !person1.getValue().contains(person.getKey())
                                && Collections.disjoint(person.getValue(), person1.getValue()))
                        .map(person1 -> Arrays.asList(person1.getKey(), person.getKey())))
                .distinct()
                .toList();

    }

    public static Map<String, Double> averageEarnings(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getEarnings)));
    }

    public static List<String> sortFilteredStrings(List<String> strings, char[] alfavit) {
        return strings.stream()
                .filter(s -> s.toLowerCase().matches("[" + new String(alfavit) + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();//(string,string1)->Integer.compare(string.length(),string1.length())

    }

    public static List<String> binaryNumbersToStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<Integer> palindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> {
                    String numStr = String.valueOf(num);
                    return new StringBuilder(numStr).reverse().toString().equals(numStr);
                })
                .boxed()
                .toList();


    }
}
