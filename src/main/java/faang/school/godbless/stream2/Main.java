package faang.school.godbless.stream2;

import org.w3c.dom.ls.LSOutput;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {


    //   На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    public static Set<List<Integer>> uniquePairOfNumbers(List<Integer> integers, int targetNumber) {
        return integers.stream()
                .flatMap(number1 -> integers.stream()
                        .filter(number2 -> !number1.equals(number2) && (number1 + number2 == targetNumber))
                        .map(number -> Arrays.asList(number, number1))
                        .peek(list -> Collections.sort(list)))
                .collect(Collectors.toSet());
//        return integers.stream()
//                .filter(number -> integers.contains(targetNumber - number))
//                .map(number -> Arrays.asList(number, targetNumber - number))
//                .peek(nums -> Collections.sort(nums))
//                .collect(Collectors.toSet());
    }

//На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.

    public static List<String> returnCapitals(Map<String, String> countryCapital) {

        return countryCapital.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(entry -> entry.getValue())
                .toList();
    }

    //Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> filterStrings(List<String> strings, char c) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(c)))
                .sorted()
                .toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей. Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static List<List<String>> oneHandshake(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .flatMap(entry1 -> map.entrySet().stream()
                        .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> entry1.getValue().stream().anyMatch(friend -> entry2.getValue().contains(friend)))
                        .map(entry2 -> Stream.of(entry2.getKey(), entry1.getKey()).sorted().toList()))
                .distinct()
                .toList();
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел. Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> departmentAverage(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
    public static List<String> sortedList(List<String> strings, char[] alphabet) {
        return strings.stream()
                .filter(word -> word.matches(("[") + String.valueOf(alphabet) + "]+"))
                .sorted((str1, str2) -> str2.length() - str1.length())
                .toList();
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> toBinaryCode(List<Integer> integers) {
        return integers.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .toList();
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> palindromes(int start, int end) {
        return IntStream.range(start, end)
                .filter(palindromeNumber -> String.valueOf(palindromeNumber).equals(new StringBuilder().append(palindromeNumber).reverse().toString()))
                .boxed()
                .toList();
//        return IntStream.range(start, end)
//                .filter(number ->{
//                    int sum = 0, remainder = 0;
//                    int temp = number;
//                    while(number > 0){
//                        remainder = number % 10;
//                        sum = (sum * 10) + remainder;
//                        number /= 10;
//                    }
//                    if (sum == temp){
//                        return true;
//                    }
//                    return false;
//                })
//                .boxed().
//                toList();
    }

    //Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами. На вход получаем строку, а вернуть должны список строк.
    public static List<String> palindromeSubstrings(String string) {
        return Stream.of(string.split(" "))
                .filter(substring -> substring.equals(new StringBuilder().append(substring).reverse().toString()) & substring.length() > 1)
                .toList();
    }

    //Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> perfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(number -> number - IntStream.range(1, number)
                        .filter(divider -> number % divider == 0 & divider != number)
                        .sum() == 0)
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("United States", "Washington D.C.");
        countryCapitals.put("United Kingdom", "London");
        countryCapitals.put("France", "Paris");
        countryCapitals.put("Germany", "Berlin");
        countryCapitals.put("Japan", "Tokyo");
        countryCapitals.put("China", "Beijing");
        countryCapitals.put("Brazil", "Brasília");
        countryCapitals.put("India", "New Delhi");
        countryCapitals.put("Russia", "Moscow");
        countryCapitals.put("Canada", "Ottawa");

        Map<String, List<String>> friendsMap = new HashMap<>();

        // Add friends and their lists of friends to the map
        addFriend(friendsMap, "Alice", Arrays.asList("Bob", "Charlie", "David"));
        addFriend(friendsMap, "Bob", Arrays.asList("Alice", "David", "Eve"));
        addFriend(friendsMap, "Charlie", Arrays.asList("Alice", "David", "Frank"));
        addFriend(friendsMap, "David", Arrays.asList("Bob", "Charlie", "Alice", "Eve"));
        addFriend(friendsMap, "Eve", Arrays.asList("Bob", "David"));
        addFriend(friendsMap, "Frank", Arrays.asList("Charlie", "George"));
        addFriend(friendsMap, "George", Arrays.asList("Frank"));


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000, "HR"));
        employees.add(new Employee("Bob", 60000, "Engineering"));
        employees.add(new Employee("Charlie", 55000, "Marketing"));
        employees.add(new Employee("David", 65000, "Finance"));
        employees.add(new Employee("Eve", 70000, "Engineering"));
        employees.add(new Employee("Frank", 62000, "HR"));
        employees.add(new Employee("Grace", 58000, "Marketing"));
        employees.add(new Employee("Harry", 68000, "Finance"));
        employees.add(new Employee("Ivy", 72000, "Engineering"));
        employees.add(new Employee("Jack", 54000, "Marketing"));
        employees.add(new Employee("Karen", 67000, "Finance"));
        employees.add(new Employee("Larry", 63000, "HR"));
        employees.add(new Employee("Megan", 59000, "Marketing"));
        employees.add(new Employee("Nancy", 71000, "Engineering"));
        employees.add(new Employee("Oliver", 56000, "Finance"));
        employees.add(new Employee("Pam", 75000, "Engineering"));
        employees.add(new Employee("Quinn", 57000, "HR"));
        employees.add(new Employee("Rose", 69000, "Marketing"));
        employees.add(new Employee("Sam", 64000, "Finance"));
        employees.add(new Employee("Tom", 74000, "Engineering"));
        employees.add(new Employee("Ursula", 61000, "HR"));
        employees.add(new Employee("Victor", 73000, "Marketing"));
        employees.add(new Employee("Wendy", 66000, "Finance"));
        employees.add(new Employee("Xander", 77000, "Engineering"));
        employees.add(new Employee("Yvonne", 68000, "HR"));
        employees.add(new Employee("Zoe", 78000, "Marketing"));

        System.out.println(oneHandshake(friendsMap));

        List<Integer> integers = List.of(1, 4, 5, 6, 7, 3, 5);
        System.out.println(uniquePairOfNumbers(integers, 9));


        List<String> strings = returnCapitals(countryCapitals);
        System.out.println(strings);

        System.out.println(departmentAverage(employees));

        List<String> randomList = new ArrayList<>();
        randomList.add("Apple");
        randomList.add("123");
        randomList.add("Banana");
        randomList.add("456");
        randomList.add("Orange");
        randomList.add("789");
        randomList.add("Mango");

        char[] alphabet = new char[26];
        char letter = 'A';
        for (int i = 0; i < 26; i++) {
            alphabet[i] = letter;
            letter++;
        }

        List<String> strings2 = List.of("CAPITAL", "WORD", "SOMETHING", "2344");

        System.out.println(filterStrings(randomList, 'O'));
        System.out.println(sortedList(strings2, alphabet));
        System.out.println(toBinaryCode(integers));
        System.out.println(palindromes(1, 1000));
        System.out.println(palindromeSubstrings("Was it a car or a cat I saw? No, it was not a palindrome but this message contains some interesting ones like radar and level !"));
        System.out.println(perfectNumbers(1, 100000));
    }


    public static List<Integer> generateNumbers(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .toList();
    }

    public static void addFriend(Map<String, List<String>> friendsMap, String friend, List<String> friendList) {
        friendsMap.put(friend, friendList);
    }
}
