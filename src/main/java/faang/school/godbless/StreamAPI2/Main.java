package faang.school.godbless.StreamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //1 subtask StreamAPI2
        List<Integer> numberList = Arrays.asList(1, 3, 7, 5, 10, 15, 2, 4, 8, 11, 5, 3, 9, 11, 17, 4, 7, 1, 0);

        System.out.println(searchUniquePairs(numberList, 10));

        //2 subtask StreamAPI2
        Map<String, String> countriesWithCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "New-York",
                "Ukraine", "Kiev",
                "Canada", "Ottawa",
                "England", "London");

        System.out.println(listCapitals(countriesWithCapitals));

        //3 subtask StreamAPI2
        List<String> listLines = Arrays.asList(
                "Amigo",
                "JavaRush",
                "Hello World",
                "Hi Vlad, welcome to IT",
                "hibernate practice");

        System.out.println(listLinesCharAtByLength(listLines, 'h'));

        //4 subtask StreamAPI2
        Map<String, List<String>> mapUsersWithFriends = Map.of(
                "user1", Arrays.asList("user3", "user5", "user4"),
                "user2", Arrays.asList("user7", "user5", "user6"),
                "user3", Arrays.asList("user8", "user9", "user10"),
                "user4", Arrays.asList("user11", "user13", "user14"));

        System.out.println(pairsManNotFriend(mapUsersWithFriends));

        //5 subtask StreamAPI2
        List<Employee> employeeList = Arrays.asList(
                new Employee("User1", 100_000, "Department1"),
                new Employee("User2", 120_000, "Department1"),
                new Employee("User3", 90_000, "Department2"),
                new Employee("User4", 95_000, "Department2"),
                new Employee("User5", 140_000, "Department3"),
                new Employee("User6", 150_000, "Department3"),
                new Employee("User7", 110_000, "Department3"),
                new Employee("User8", 60_000, "Department1")
        );

        System.out.println(averageSalaryByDepartment(employeeList));

        //6 subtask StreamAPI2
        String specificCharset = "[acfheloiyv\s]+?";
        List<String> listStringToSpecificCharset = Arrays.asList("Hello", "fly hello", "cell", "aloha hello fly",
                "random line", "irregular line");

        System.out.println(listLinesFilterByCharset(listStringToSpecificCharset, specificCharset));

        //7 subtask StreamAPI2
        List<Integer> listIntegersToBinaryString = Arrays.asList(1, 2, 5, 2, 6);

        System.out.println(intToBinaryString(listIntegersToBinaryString));

        //8 subtask StreamAPI2
        System.out.println(searchPalindromeNumbers(11, 55));

    }

    //1 subtask StreamAPI2
    static List<List<Integer>> searchUniquePairs(List<Integer> integerList, int targetValue) {

        return integerList.stream()
                .flatMap(value1 -> integerList.stream()
                        .filter(value2 -> value1 + value2 == targetValue)
                        .map(val2 -> Stream.of(value1, val2).sorted().toList()))
                .distinct()
                .toList();

    }

    //2 subtask StreamAPI2
    static List<String> listCapitals(Map<String, String> countriesWithCapitals) {

        return countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

    }

    //3 subtask StreamAPI2
    static List<String> listLinesCharAtByLength(List<String> listLines, char s) {

        return listLines.stream()
                .filter(str -> str.toLowerCase().charAt(0) == s)
                .sorted(Comparator.comparing(String::length))
                .toList();

    }

    //4 subtask StreamAPI2
    static List<List<String>> pairsManNotFriend(Map<String, List<String>> usersWithFriendsList) {

        return usersWithFriendsList.entrySet().stream()
                .flatMap(entry1 -> usersWithFriendsList.entrySet().stream()
                        .filter(entry2 -> !entry2.getKey().equalsIgnoreCase(entry1.getKey()))
                        .filter(entry2 -> !entry2.getValue().contains(entry1.getKey()))
                        .filter(entry2 -> entry1.getKey().compareTo(entry2.getKey()) > 0)
                        .filter(entry2 -> !Collections.disjoint(entry2.getValue(), entry1.getValue()))
                        .map(entry2 -> Arrays.asList(entry1.getKey(), entry2.getKey())))
                .toList();

    }

//    static Set<List<String>> uniquePairs(Map<String, List<String>> usersWithFriendsList) {
//        return usersWithFriendsList.entrySet().stream()
//                .flatMap(entry1 -> usersWithFriendsList.entrySet().stream()
//                        .filter(entry2 -> !entry2.getKey().equals(entry1.getKey())
//                                && !entry1.getValue().contains(entry2.getKey())
//                                && !Collections.disjoint(entry1.getValue(), entry2.getValue())
//                                && entry1.getKey().compareTo(entry2.getKey()) < 0)
//                        .map(entry2 -> new ArrayList<>(Arrays.asList(entry1.getKey(), entry2.getKey()))))
//                .collect(Collectors.toSet());
//
//    }

//    static Set<Map.Entry<String, String>> uniquePairs(Map<String, List<String>> usersWithFriendsList) {
//        return usersWithFriendsList.entrySet().stream()
//                .flatMap(entry1 -> usersWithFriendsList.entrySet().stream()
//                        .filter(entry2 -> !entry2.getKey().equals(entry1.getKey())
//                                && !entry1.getValue().contains(entry2.getKey())
//                                && !Collections.disjoint(entry1.getValue(), entry2.getValue())
//                                && entry1.getKey().compareTo(entry2.getKey()) < 0)
//                        .map(entry2 -> Map.entry(entry1.getKey(), entry2.getKey())))
//                .collect(Collectors.toSet());
//
//    }

    //5 subtask StreamAPI2
    static Map<String, Double> averageSalaryByDepartment(List<Employee> listEmployee) {

        if (listEmployee == null || listEmployee.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty.");
        }

        return listEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

    }

    //6 subtask StreamAPI2
    static List<String> listLinesFilterByCharset(List<String> listLines, String specificCharset) {

        return listLines.stream()
                .filter(str -> str.toLowerCase().matches(specificCharset))
                .sorted(Comparator.comparing(String::length))
                .toList();

    }

    //7 subtask StreamAPI2
    static List<String> intToBinaryString(List<Integer> integerList) {

        return integerList.stream()
                .map(Integer::toBinaryString)
                .toList();

    }

    static List<Integer> searchPalindromeNumbers(int startRange, int endRange) {

        return IntStream.rangeClosed(startRange, endRange)
                .filter(value -> String.valueOf(value).contentEquals(new StringBuilder(String.valueOf(value)).reverse()))
                .boxed()
                .toList();

    }
}
