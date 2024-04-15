package faang.school.godbless.BJS2_5424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        System.out.println(getUniquePairOfSum(List.of(1, 2, 3, 4, 5, 6, 7), 5));
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Б", "Москва");
        countriesAndCapitals.put("А", "Рим");
        countriesAndCapitals.put("В", "Берлин");
        countriesAndCapitals.put("Д", "Мадрид");
        countriesAndCapitals.put("Г", "Лондон");
        System.out.println(sortCountriesAndReturnCapitals(countriesAndCapitals));
        System.out.println(filterStringByCharAndSortByLength(List.of("apple", "ananas", "banana"), 'a'));

        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", List.of("Charlie"));
        friendships.put("Bob", List.of("George", "Alice"));
        friendships.put("Charlie", List.of("Alice", "Eric"));
        friendships.put("David", List.of("Charlie"));

        System.out.println(getAllFriendOfFriends(friendships));

        Employee employee1 = new Employee("Scott", 3000, "transport");
        Employee employee2 = new Employee("Mary", 5000, "transport");
        Employee employee3 = new Employee("John", 2000, "economy");
        Employee employee4 = new Employee("Kate", 4000, "economy");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        System.out.println(getAverageSalary(employees));

        System.out.println((getWordsByAlphabet(List.of("hello", "123", "привет", "hi"))));
        System.out.println(toBinaryString(List.of(1, 2, 3, 4, 5)));
        System.out.println(getPalindrome(List.of(121, 2333, 555)));
    }

    public static Map<Integer, Integer> getUniquePairOfSum(List<Integer> ints, int target) {
        Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0, ints.size())
                .forEach(i -> IntStream.range(i + 1, ints.size()).
                        filter(j -> ints.get(j) + ints.get(i) == target).
                        forEach(x -> pairs.put(ints.get(x), ints.get(i))));
        return pairs;
    }

    public static List<String> sortCountriesAndReturnCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> filterStringByCharAndSortByLength(List<String> strs, char ch) {
        return strs.stream().
                filter(x -> x.startsWith(String.valueOf(ch))).
                sorted(Comparator.comparing(String::length)).toList();
    }

    private static HashMap<String, String> getAllFriendOfFriends(Map<String, List<String>> peoplesFriends) {
        HashMap<String, String> pairs = new HashMap<>();
        peoplesFriends.forEach((key, value) ->
                peoplesFriends.entrySet().stream(). // создаем стрим из нашей мапы с друзьями друзей
                        filter(entry -> !key.equals(entry.getKey()) && !value.contains(entry.getKey())) // фильтруем наш стрим на то чтобы текущий человек не находился в списке друзей другого человека
                        .forEach(entry -> entry.getValue().stream() // создаем стрим из списка друзей текущего человека
                                .filter(value::contains) // отфильровываем так чтобы в списке друзей текущего человека находился тот друг который есть у нас в текущем стриме
                                .forEach(friend -> pairs.put(key, entry.getKey()))) // проходимся по отфильтровановому стриму и добавляем в мапу людей с общими знакомыми
        );
        return pairs;
    }

    public static Map<String, Double> getAverageSalary(List<Employee> workers) {
        return workers.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> getWordsByAlphabet(List<String> words) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return words.stream().filter(word -> Arrays.stream(alphabet.split("")).anyMatch(word::contains)).
                sorted(Comparator.comparing(String::length)).toList();
    }

    public static List<String> toBinaryString(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> getPalindrome(List<Integer> nums) {
        return nums.stream().filter(x -> new StringBuilder(x.toString()).compareTo(new StringBuilder(x.toString()).reverse()) == 0).toList();
    }
}
