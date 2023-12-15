package streamAPI_2_932;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args) {

        int num = 10;
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 5);
        System.out.println(getUniquePairs(numbers, num));

        Map<String, String> countries = Map.of(
                "England", "London", "Russia", "Moscow", "France", "Paris");
        System.out.println(getNameCapital(countries));

        List<String> strings = Arrays.asList("Maserati", "Opel", "Mazda", "Mini", "Hyundai");
        System.out.println(convertStrings(strings, 'm'));

        Map<String, List<String>> friends = Map.of("Ketty", Arrays.asList("Bob", "David"),
                "Anna", Arrays.asList("David", "Ira"),
                "Bob", Arrays.asList("Ketty", "Ira"));
        System.out.println(getPairNoFriends(friends));

        List<Employee> employees = List.of(new Employee("Bob", 100, "Dep1"),
                new Employee("Klara", 200, "Dep1"),
                new Employee("David", 50, "Dep2"),
                new Employee("Bob", 30, "Dep1"));
        System.out.println(calcAverageDepartSalary(employees));

        List<String> letters = List.of("a", "m", "z", "d", "i", "n");
        List<Character> letter1 = List.of('a', 'n', 'i', 'm', 'z', 'd');
        System.out.println(filterStringsByAlphabet(strings, letter1));

        System.out.println(convertToBinary(numbers));

        System.out.println(getPolidrom(10, 40));
    }

    // Задание 1 Найдите все уникальные пары чисел, сумма которых равна заданному числу
    public static Set<List<Integer>> getUniquePairs(List<Integer> numbers, int num) {
        Set<List<Integer>> result = new HashSet<>();
        numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(p -> i + p == num && numbers.indexOf(i) != numbers.lastIndexOf(p))
                        .map(p -> result.add((i < p) ? Arrays.asList(i, p) : Arrays.asList(p, i))))
                .toList();
        return result;
    }

    // Задание 2 Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> getNameCapital(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .toList();
    }

    // Задание 3 Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> convertStrings(List<String> strings, Character character) {
        return strings.stream()
                .filter(str -> str.substring(0, 1).equalsIgnoreCase(character.toString()))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // Задание 4 Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static List<List<String>> getPairNoFriends(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(friend1 -> friends.entrySet().stream()
                        .filter(friend2 -> !friend2.getKey().equals(friend1.getKey())) //исключаем проверять себя самого
                        .filter(friend2 -> !friend2.getValue().contains(friend1.getKey())) //друг1 и друг2 не дружат
                        .filter(friend2 -> friend2.getValue().stream()
                                .anyMatch(friendFriend2 -> friend1.getValue().contains(friendFriend2)))
                        .map(friend2 -> Arrays.asList(friend1.getKey(), friend2.getKey())) //Как тут записать уникальные пары?
                )
                .toList();
    }

    // Задание 5 Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой
    public static Map<String, Double> calcAverageDepartSalary(List<Employee> employees) {
        Map<String, Double> averageDepartSalary = new HashMap<>();
        employees.stream()
                .map(employee -> averageDepartSalary.put(employee.getDepartment(), employees.stream()
                        .filter(employee1 -> employee1.getDepartment().equals(employee.getDepartment()))
                        .mapToInt(Employee::getSalary)
                        .average()
                        .orElse(0)))
                .toList();
        return averageDepartSalary;
    }

    // Задание 6 Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    // и отсортируйте их в порядке возрастания длины строк.
    public static List<String> filterStringsByAlphabet(List<String> strings, List<Character> letters) {
        return strings.stream()
                .filter(string -> string.toLowerCase().chars()
                        .allMatch(let -> letters.contains((char) let)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // Задание 7 Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> convertToBinary(List<Integer> integers) {
        return integers.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .toList();
    }

    // Задание 8 Написать метод, который найдет все числа-палиндромы
    // (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
    public static List<Integer> getPolidrom(Integer intFrom, Integer intTo) {
        return IntStream.rangeClosed(intFrom, intTo)
                .filter(i -> new StringBuilder(String.valueOf(i)).reverse().toString().equals(String.valueOf(i)))
                .boxed()
                .toList();
    }
}