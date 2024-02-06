package faang.school.godbless.BJS2_960;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = List.of(1, 2, 4, 5, 3, 3, 3, 5, 5);
        System.out.println(searchPairs(listOfIntegers, 5));

        Map<String, String> countryAndCapital = Map.of("Japan", "Tokyo", "Kazakhstan", "Almaty", "Germany", "Berlin");
        System.out.println(capitals(countryAndCapital));

        List<String> listOfString = List.of("Jackson", "Armando", "Reece", "Robert");
        System.out.println(filterByChar(listOfString, 'R'));


        System.out.println(filterByAlphabet(listOfString, "armandojackson"));
        System.out.println(bin(listOfIntegers));
        System.out.println(palindrome(1, 10000));
    }

    public static List<List<Integer>> searchPairs (List<Integer> listOfInt, int target) {
         return listOfInt.stream()
                 .flatMap(num1 -> listOfInt.stream().map(num2 -> List.of(num1, num2)))
                 .filter(pair -> {
                     int firstNum = pair.get(0);
                     int secondNum = pair.get(1);
                     return firstNum+secondNum == target;
                 })
                 .distinct().toList();
    }

    public static List<String> capitals (Map<String, String> countryAndCapital) {
        return countryAndCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();

    }

    public static List<String> filterByChar (List<String> listOfString, char letter){
        return listOfString.stream()
                .filter(string -> string.charAt(0)==letter)
                .sorted(Comparator.naturalOrder()).toList();

    }

    public static List<List<String>> findMutualFriends(Map<String, List<String>> listOfFriends){
        return listOfFriends.entrySet().stream()
                .flatMap(human ->
                        listOfFriends.entrySet().stream()
                                .filter(anotherHuman ->
                                    !human.getKey().equals(anotherHuman.getKey()) &&
                                    !human.getValue().contains(anotherHuman.getKey()) &&
                                    !Collections.disjoint(human.getValue(), anotherHuman.getValue())
                                )
                                .map(anotherHuman -> List.of(human.getKey(), anotherHuman.getKey())))
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Double> findAverageSalary(List<Employee> employeeList){
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterByAlphabet(List<String> stringList, String alphabet){
        return stringList.stream()
                .filter(s -> s.toLowerCase().chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> bin(List<Integer> integerList){
        return integerList.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<Integer> palindrome (int start, int end) {
        return IntStream.range(start, end)
                .filter(n -> String.valueOf(n).equals(new StringBuilder(String.valueOf(n)).reverse()))
                .boxed().toList();
    }
}
