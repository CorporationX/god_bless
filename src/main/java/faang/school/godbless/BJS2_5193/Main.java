package faang.school.godbless.BJS2_5193;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        List<Integer> numbers = new ArrayList<>(List.of(1, 9, 3, 6, 4, 5));
        List<String> strings = new ArrayList<>(List.of("Мимоходом", "Перенаселение", "Успокоиться", "Колун", "Кружить"));
        List<Employee> employees = new ArrayList<>();
        List<String> stringList = new ArrayList<>(List.of("apple", "banana", "123", "dog", "cat"));
        Map<String, String> locations = new HashMap<>();
        Map<String, List<String>> userMap = new HashMap<>();


        locations.put("Испания", "Мадрид");
        locations.put("Франция", "Париж");
        locations.put("Великобритания", "Лондон");

        userMap.put("Иван", new ArrayList<>(List.of("Матвей", "Алиса")));
        userMap.put("Яков", new ArrayList<>(List.of("Матвей")));
        userMap.put("Матвей", new ArrayList<>(List.of("Яков", "Иван")));
        userMap.put("Алиса", new ArrayList<>(List.of("Иван")));

        employees.add(new Employee("Питер", 200, "Повар"));
        employees.add(new Employee("Саша", 600, "Администратор"));
        employees.add(new Employee("Артём", 300, "Повар"));

        System.out.println(StreamAPIService.findAllUniquePairsWhoseSumIsEqualToNumber(numbers, 10));
        System.out.println(StreamAPIService
                .takeNameOfCapitalFromCountryAlphabetically(new HashMap<>(locations)));

        System.out.println(StreamAPIService.sortAndFilterStringByChar(strings, 'К'));
        System.out.println(StreamAPIService.findUnfamiliarPeopleWithMutualFriends(userMap));
        System.out.println(StreamAPIService.findMediumSalaryForEachDepartment(employees));
        System.out.println(StreamAPIService.filterLinesThatConsistOfAlphabet(stringList, alphabet));
        System.out.println(StreamAPIService.transformListOfIntToListOfBinaryString(numbers));
        System.out.println(StreamAPIService.findAllPalindromeFromRange(1, 100));
        System.out.println(StreamAPIService.findAllSubstringPalindromeInString("оаокакыяфф"));
        System.out.println(StreamAPIService.findAGreatNumber(1, 10000));

    }
}
