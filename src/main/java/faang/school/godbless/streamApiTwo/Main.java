package faang.school.godbless.streamApiTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final List<Integer> listOfNumbers = List.of(1, 9, 3, 6, 4, 5);
    private static final int targetSum = 10;
    private static final Map<String, String> countryAndCapital = new HashMap<>();
    private static final List<String> listOfStrings
            = List.of("Japan", "Tokyo", "Jamaica", "Kingston", "Iceland", "Reykjavik", "Bulgaria", "Sofia", "Afghanistan", "Kabul");
    private static final Map<String, List<String>> namesAndFriendsNames = new HashMap<>();
    private static final List<Employee> employees = List.of(
            new Employee("David", 25000, "DevOps"),
            new Employee("William", 40000, "Sales"),
            new Employee("Brandon", 38000, "Sales"),
            new Employee("Matthew", 15000, "Developer"));
    private static final List<String> input = List.of("apple", "banana", "123", "dog", "cat");
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {
        countryAndCapital.put("Japan", "Tokyo");
        countryAndCapital.put("Jamaica", "Kingston");
        countryAndCapital.put("Iceland", "Reykjavik");
        countryAndCapital.put("Bulgaria", "Sofia");
        countryAndCapital.put("Afghanistan", "Kabul");
        namesAndFriendsNames.put("David", List.of("James", "Robert", "John", "Michael"));
        namesAndFriendsNames.put("William", List.of("Richard", "Joseph", "John", "David"));
        namesAndFriendsNames.put("Matthew", List.of("Richard", "Robert", "Charles"));
        namesAndFriendsNames.put("Brandon", List.of("Gregory", "Alexander", "Patrick", "Frank"));

        System.out.println("The List of pair that sum equal to " +
                targetSum + " is: " + findPairsThatMakesSum(listOfNumbers, targetSum));
        capitalsByCountryAlphabeticOrder(countryAndCapital);
        System.out.println(filterStringsByStartsFromAndLength(listOfStrings, 'J'));
        System.out.println(notFriendsButHasMutualFriends(namesAndFriendsNames));
        System.out.println(findAverageSalaryByDepartment(employees));
        filterByCurrentAlphabet(input, alphabet);
        System.out.println(changeIntToBinaryString(listOfNumbers));
        System.out.println(findAllPolynoms(1, 101));


    }

    public static Set<List<Integer>> findPairsThatMakesSum(List<Integer> list, int targetSum) {
        return list.stream()
                .flatMap(num1 -> list.stream()
                        .filter(num2 -> list.indexOf(num2) > list.indexOf(num1))
                        .filter(num2 -> num1 + num2 == targetSum)
                        .map(num2 -> Arrays.asList(num1, num2)))
                .collect(Collectors.toSet());
        // without Stream API
//        Set<List<Integer>> allPairs = new HashSet<>();
//        int length = list.toArray().length;
//        for (int i = 0; i< length-2; i++){
//            int num1 = list.get(i);
//            for(int j =i; j < length-1; j++ ){
//                int num2 = list.get(j);
//                if(num1 + num2 == targetSum) {
//                    List<Integer> pair = new ArrayList<>();
//                    pair.add(num1);
//                    pair.add(num2);
//                    allPairs.add(pair);
//                }
//            }
//        }
//        return allPairs;
    }

    public static void capitalsByCountryAlphabeticOrder(Map<String, String> countryAndCapital) {
        System.out.println("Capital cities by country alphabetic order: " +
                countryAndCapital.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList());
    }

    public static List<String> filterStringsByStartsFromAndLength(List<String> listOfStrings, char startCharacter) {
        return listOfStrings.stream().
                filter(s -> s.charAt(0) == startCharacter)
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<List<String>> notFriendsButHasMutualFriends(Map<String, List<String>> namesAndFriendsNames) {
        return namesAndFriendsNames.entrySet().stream()
                .flatMap(entry1 -> namesAndFriendsNames.entrySet().stream()
                        .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                        .map(entry2 -> {
                            List<String> pair = new ArrayList<>(Arrays.asList(entry1.getKey(), entry2.getKey()));
                            pair.sort(Comparator.naturalOrder());
                            return pair;
                        }))
                .distinct().toList();
        //without stream API
//        List<List<String>> hasMutualFriends = new ArrayList<>();
//        Set<String> names = namesAndFriendsNames.keySet();
//        for(String name :names){
//            for (String person : namesAndFriendsNames.keySet()){
//                if(!name.equals(person)){
//                    if(!namesAndFriendsNames.get(person).contains(name)){
//                        for(String nameFriendName : namesAndFriendsNames.get(name)){
//                            for(String personFriendName : namesAndFriendsNames.get(person)){
//                                if(nameFriendName.equals(personFriendName)){
//                                    if(!hasMutualFriends.contains(List.of(person,name))){
//                                        hasMutualFriends.add(List.of(name, person));
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return hasMutualFriends;
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

    }

    private static void filterByCurrentAlphabet(List<String> input, String alphabet) {
        System.out.println(
                input.stream()
                        .filter(word -> word.chars()
                                .allMatch(eachChar -> alphabet
                                        .contains(String.valueOf((char) eachChar))))
                        .sorted(Comparator.comparingInt(String::length))
                        .toList()
        );
    }

    private static List<String> changeIntToBinaryString(List<Integer> listOfInts) {
        return listOfInts.stream().map(Integer::toBinaryString).toList();
    }

    private static List<Integer> findAllPolynoms(int start, int stop) {
        return IntStream.rangeClosed(start, stop)
                .filter(num -> {
                    String strNum = String.valueOf(num);
                    String reversed = new StringBuilder(strNum).reverse().toString();
                    return strNum.equals(reversed) && strNum.length() > 1;
                }).boxed()
                .toList();
    }

}
