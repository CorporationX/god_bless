package faang.school.godbless.BJS2_10713;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class APP_10713 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 5, 6, 6, 5, 49, 8, 4, 6, 54, 68, 64, 56, 35);
        System.out.println(findUniqueCombinations(72, nums));
        Map<String, String> countiesWithCapitals = new HashMap<>();
        countiesWithCapitals.put("Austria", "Venus");
        countiesWithCapitals.put("England", "London");
        countiesWithCapitals.put("Belgium", "Brussels");
        countiesWithCapitals.put("Bulgaria", "Sofia");
        countiesWithCapitals.put("Hungary", "Budapest");
        countiesWithCapitals.put("Germany", "Berlin");
        countiesWithCapitals.put("Greece", "Athens");
        countiesWithCapitals.put("Denmark", "Copenhagen");
        countiesWithCapitals.put("Ireland", "Dublin");
        countiesWithCapitals.put("Cyprus", "Nicosia");
        countiesWithCapitals.put("Latvia", "Riga");
        countiesWithCapitals.put("Malta", "Valletta");
        countiesWithCapitals.put("Monaco", "Monaco");
        countiesWithCapitals.put("Netherlands", "Amsterdam");
        countiesWithCapitals.put("Canada", "Ottawa");
        countiesWithCapitals.put("France", "Paris");
        countiesWithCapitals.put("Gabon", "Libreville");
        countiesWithCapitals.put("Haiti", "Port-au-Prince");
        countiesWithCapitals.put("India", "New Delhi");
        countiesWithCapitals.put("Japan", "Tokyo");
        System.out.println(getCapitals(countiesWithCapitals));
        List<String> strings = List.of("Hello", "Moscow", "Summer", "Pan", "Peach", "Radiator", "Grass", "Orange", "Tree", "Potato", "Tomato", "Sunrise", "Darkness", "Car", "Telephone");
        System.out.println(getAbsListStartsWith('P', strings));
        Map<String, List<String>> peoples = new HashMap<>();
        peoples.put("Alfred", List.of("Ann", "Kate", "Tom"));
        peoples.put("Jennifer", List.of("George", "Kate", "Susanne"));
        peoples.put("George", List.of("Jennifer", "Susanne", "Tom"));
        peoples.put("Susanne", List.of("Jennifer", "Kate", "Tom"));

        Employee employeeEdward = new Employee("Edward", 1500, "IT Department");
        Employee employeeKate = new Employee("Kate", 800, "Legal Department");
        Employee employeeBishop = new Employee("Bishop", 750, "Engineering Department");
        Employee employeeJames = new Employee("James", 1900, "Legal Department");
        Employee employeeAnn = new Employee("Ann", 2100, "Engineering Department");
        Employee employeeStewart = new Employee("Stewart", 600, "Legal Department");
        Employee employeeBenedikt = new Employee("Benedikt", 680, "IT Department");
        Employee employeeAlisson = new Employee("Alisson", 990, "Engineering Department");
        Employee employeeHelen = new Employee("Helen", 1350, "Legal Department");
        Employee employeeLisa = new Employee("Lisa", 1780, "IT Department");
        List<Employee> employees = List.of(employeeEdward, employeeKate, employeeBishop, employeeJames, employeeAnn, employeeStewart, employeeBenedikt, employeeAlisson, employeeHelen, employeeLisa);
        System.out.println(getAverageSalary(employees));
        List<String> secondStrings = List.of("dog", "apple", "banana", "123", "cat");
        Set<Character> alphabet = Set.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        System.out.println(getAlphabetAscList(secondStrings, alphabet));
        List<Integer> intNums = List.of(1, 5, 3, 5, 4, 98, 6, 45, 6);
        System.out.println(convertToBinary(intNums));
        System.out.println(getAllPalindromesWithin(10, 500));

        System.out.println(getPairs(peoples));
    }

    public static List<List<Integer>> findUniqueCombinations(int sum, List<Integer> nums) {

        return IntStream.range(0, nums.size())
                .boxed().
                flatMap(outIndex ->
                        IntStream.range(outIndex + 1, nums.size())
                                .filter(innerIndex -> nums.get(outIndex) + nums.get(innerIndex) == sum)
                                .mapToObj(value -> List.of(nums.get(outIndex), nums.get(value)))
                )
                .distinct()
                .toList();
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getAbsListStartsWith(char symbol, List<String> list) {
        return list.stream()
                .filter(str -> str.startsWith(Character.toString(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<List<String>> getPairs(Map<String, List<String>> people) {
        return people.entrySet().stream()
                .flatMap(person1 ->
                        people.keySet().stream()
                                .filter(entry -> !person1.getKey().equals(entry) && !person1.getValue().contains(entry))
                                .map(notFriends -> {
                                    List<String> pair = Arrays.asList(person1.getKey(), notFriends);
                                    Collections.sort(pair);
                                    return pair;
                                })
                )
                .distinct()
                .toList();
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getAlphabetAscList(List<String> text, Set<Character> alphabet) {
        return text.stream().filter(str -> str.chars().allMatch(ch -> alphabet.contains((char) ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> getAllPalindromesWithin(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(num -> {
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
                    return stringBuilder.reverse().toString().equals(String.valueOf(num));
                }).toList();
    }

}