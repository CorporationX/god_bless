package faang.school.godbless.practice.streamapi2.test;

import faang.school.godbless.practice.streamapi2.Employee;
import faang.school.godbless.practice.streamapi2.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPractice {
    public static void main(String[] args) {
        testGetListOfUniquePairsWhichSumEqualsToCertainNumber();
        testSortCountriesAndGetListOfCapitals();
        testGetListOfStringsFilterBySpecificCharacterAndSortedByLengthAsc();
        testGetListOfPeopleWhoAreNotFriendsButHaveCommonFriends();
        testGetDepartmentToAvgSalaryMap();
        testGetStringsListFilteredByAlphabetRelating();
        testGetListNumbersInBinaryFormat();
        testGetPalindromesListOnRange();
    }

    public static void testGetListOfUniquePairsWhichSumEqualsToCertainNumber() {
        List<Integer> numbers1 = new ArrayList<>(List.of(8, 8, 3, 5, 5, 1, 2, 7, 4, 6));
        List<Integer> numbers2 = new ArrayList<>(List.of(8, 8, 5, 12, 15, 7, 4, 67));
        List<Integer> numbers3 = new ArrayList<>(List.of(8, 8, 3, 5, 25, 1, 2, 7, 4, 6));
        List<int[]> pairsList1 = Practice.getListOfUniquePairsWhichSumEqualsToCertainNumber(numbers1, 10);
        pairsList1.forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("-----------------------------------------------------------------------------------------");
        List<int[]> pairsList2 = Practice.getListOfUniquePairsWhichSumEqualsToCertainNumber(numbers2, 10);
        pairsList2.forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("-----------------------------------------------------------------------------------------");
        List<int[]> pairsList3 = Practice.getListOfUniquePairsWhichSumEqualsToCertainNumber(numbers3, 30);
        pairsList3.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static void testSortCountriesAndGetListOfCapitals() {
        Map<String, String> countriesToCapitals1 = new HashMap<>(Map.of(
                "Yemen", "Sanaa",
                "Somalia", "Mogadishu",
                "Norway", "Oslo",
                "Mexico", "Mexico City",
                "Japan", "Tokyo"
        ));
        List<String> pairsList1 = Practice.sortCountriesAndGetListOfCapitals(countriesToCapitals1);
        System.out.println(pairsList1);
    }

    public static void testGetListOfStringsFilterBySpecificCharacterAndSortedByLengthAsc() {
        List<String> strings1 = new ArrayList<>(List.of("4312333", "44322", "89432", "43995223", "2230", "8933333"));

        List<String> result1 = Practice.getListOfStringsFilteredBySpecificCharacterAndSortedByLengthAsc(strings1, '8');
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(result1);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");

        List<String> result2 = Practice.getListOfStringsFilteredBySpecificCharacterAndSortedByLengthAsc(strings1, '4');
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(result2);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void testGetListOfPeopleWhoAreNotFriendsButHaveCommonFriends() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Name1", new ArrayList<>(List.of("Name2", "Name3", "Name4")));
        map.put("Name5", new ArrayList<>(List.of("Name4", "Name6", "Name7")));
        map.put("Name6", new ArrayList<>(List.of("Name4", "Name8", "Name9")));
        map.put("Name7", new ArrayList<>(List.of("Name3", "Name10", "Name11")));

        List<List<String>> pairs = Practice.getListOfPeopleWhoAreNotFriendsButHaveCommonFriends(map);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        pairs.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void testGetDepartmentToAvgSalaryMap() {
        Employee employee1 = Employee.builder()
                .name("Employee1")
                .salary(443_949_384)
                .department("Department1")
                .build();
        Employee employee2 = Employee.builder()
                .name("Employee2")
                .salary(223_949_384)
                .department("Department1")
                .build();
        Employee employee3 = Employee.builder()
                .name("Employee3")
                .salary(888_949_384)
                .department("Department1")
                .build();
        Employee employee4 = Employee.builder()
                .name("Employee4")
                .salary(111_949_384)
                .department("Department1")
                .build();
//        --------------------------------------------------------------------------------------------------------------
        Employee employee5 = Employee.builder()
                .name("Employee5")
                .salary(949_384)
                .department("Department2")
                .build();
        Employee employee6 = Employee.builder()
                .name("Employee6")
                .salary(111_384)
                .department("Department2")
                .build();
        Employee employee7 = Employee.builder()
                .name("Employee3")
                .salary(221_384)
                .department("Department2")
                .build();
        Employee employee8 = Employee.builder()
                .name("Employee4")
                .salary(555_384)
                .department("Department2")
                .build();
        //        --------------------------------------------------------------------------------------------------------------
        Employee employee9 = Employee.builder()
                .name("Employee9")
                .salary(43_384)
                .department("Department3")
                .build();
        Employee employee10 = Employee.builder()
                .name("Employee10")
                .salary(22_384)
                .department("Department3")
                .build();
        Employee employee11 = Employee.builder()
                .name("Employee11")
                .salary(99_384)
                .department("Department3")
                .build();
        Employee employee12 = Employee.builder()
                .name("Employee12")
                .salary(66_384)
                .department("Department3")
                .build();

        List<Employee> employees = new ArrayList<>(List.of(
                employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9,
                employee10, employee11, employee12
        ));

        Map<String, Double> result = Practice.getDepartmentToAvgSalaryMap(employees);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        result.forEach((key, value) -> System.out.printf("%s = %.0f %n", key, value));
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void testGetStringsListFilteredByAlphabetRelating() {
        List<String> engAlphabet = new ArrayList<>();
        char character = 'a';
        for (int i = 'a'; i <= 'z'; i++) {
            engAlphabet.add(String.valueOf(character));
            character++;
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(engAlphabet);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");

        List<String> rusAlphabet = new ArrayList<>();
        character = 'а';
        for (int i = 'а'; i <= 'я'; i++) {
            rusAlphabet.add(String.valueOf(character));
            character++;
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(rusAlphabet);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");

        List<String> list1 = new ArrayList<>(List.of("123juuv", "kksverrin", "FEEWEvk", "ed", "ssssss", "аааааяяяяяя"));
        List<String> list2 = new ArrayList<>(List.of("123juuv", "фымдфотамлфова", "ОЛОЛУауацп", "уа", "ллллл", "ggggeeeeee"));

        List<String> result1 = Practice.getStringsListFilteredByAlphabetRelating(list1, engAlphabet.toArray(String[]::new));
        List<String> result2 = Practice.getStringsListFilteredByAlphabetRelating(list2, rusAlphabet.toArray(String[]::new));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(result1);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(result2);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void testGetListNumbersInBinaryFormat() {
        List<String> result = Practice.getListNumbersInBinaryFormat(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 333335, 5452352, 5339)));
        result.forEach(System.out::println);
    }

    public static void testGetPalindromesListOnRange() {
        List<Integer> result = Practice.getPalindromesListOnRange(1, 100000);
        result.forEach(System.out::println);
    }
}
