package faang.school.godbless.streamApi.streamApi2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1, 9, 7, 6, 4, 5, 5, 5);
        System.out.println(getPairsWithSum(nums, 10));

        Map<String, String> countries = Map.of("Russia", "Moscow",
                "Great Britain", "London", "Germany", "Berlin", "Austria", "Vienna");
        System.out.println(getCapitals(countries));

        List<String> strings = List.of("jdfkg", "dkfj", "dhks", "ekll", "dalje");
        System.out.println(getSortedStringsStartsWith(strings, strings.get(2).charAt(0)));

        Map<String, List<String>> friendsOfPersons = Map.of(
                "Masha", List.of("Petya", "Vasya", "Dasha"),
                "Kirill", List.of("Vitaliy", "Dasha", "Petya"),
                "Petya", List.of("Masha", "Vitaliy", "Vasya", "Kirill"),
                "Vasya", List.of("Masha", "Petya", "Vitaliy"),
                "Dasha", List.of("Masha", "Kirill"),
                "Vitaliy", List.of("Petya", "Kirill", "Vasya")
        );
        System.out.println(getNonFriendsWithMutualFriends(friendsOfPersons));

        List<Employee> employees = List.of(
                new Employee("Vasya", 100_000, "dep1"),
                new Employee("Petya", 140_000, "dep1"),
                new Employee("Kirill", 128_000, "dep2"),
                new Employee("Masha", 158_000, "dep2"),
                new Employee("Dasha", 120_000, "dep2"),
                new Employee("Vladimir", 110_000, "dep1")
        );
        System.out.println(getAvgSalariesOfDepartments(employees));

        List<String> words = List.of("word", "house", "674", "слово", "dad");
        System.out.println(getStringsByAlphabet(words));

        List<Integer> ints = List.of(42, 2, 1, 567, 5);
        System.out.println(getBinaryByInts(ints));

        System.out.println(getNumPalindromesInRange(34600, 34800));
    }

    //    На вход дан список целых чисел и число.
    //    Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    public static List<Pair> getPairsWithSum(List<Integer> nums, int sum) {
        Set<Pair> pairs = new HashSet<>();
        nums.forEach(i -> nums.forEach(j -> {
            if (i + j == sum) {
                pairs.add(new Pair(i, j));
            }
        }));
        return pairs.stream().toList();
    }

    //    На вход получаем мапу с названиями стран и их столицами.
    //    Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> getCapitals(Map<String, String> countries) {
        TreeMap<String, String> sorted = new TreeMap<>(countries);
        return sorted.values().stream().toList();
    }

    //    Получаем список строк и букву в виде char.
    //    Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте
    //    их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> getSortedStringsStartsWith(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.charAt(0) == letter)
                .sorted().toList();
    }

    //    Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    //    Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static List<PersonPair> getNonFriendsWithMutualFriends(Map<String, List<String>> friendsOfPersons) {
        Set<PersonPair> pairs = new HashSet<>();
        friendsOfPersons.forEach((person1, friends1) -> friendsOfPersons.forEach((person2, friends2) -> {
            List<String> copyFriends = new ArrayList<>(friends1);
            copyFriends.retainAll(friends2);
            if (!person1.equals(person2) && !friends1.contains(person2) && !copyFriends.isEmpty()) {
                pairs.add(new PersonPair(person1, person2));
            }
        }));
        return pairs.stream().toList();
    }

    //    Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    //    Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> getAvgSalariesOfDepartments(List<Employee> employees) {
        Map<String, List<Integer>> salariesOfDepartments = new HashMap<>();
        employees.forEach(employee -> salariesOfDepartments
                .computeIfAbsent(employee.getDepartment(), v -> new ArrayList<>()).add(employee.getSalary()));
        return salariesOfDepartments.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().
                        mapToInt(a -> a).average().orElse(0)));
    }

    //    Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    //    и отсортируйте их в порядке возрастания длины строк.
    public static List<String> getStringsByAlphabet(List<String> strings) {
        return strings.stream()
                .filter(s -> s.matches("^[a-zA-Z]*$"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //    Написать метод, который преобразует список целых чисел в список строк,
    //    где каждое число записано в двоичном виде.
    public static List<String> getBinaryByInts(List<Integer> ints) {
        return ints.stream().map(Integer::toBinaryString).toList();
    }

    //    Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
    //    в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> getNumPalindromesInRange(int start, int end) {
        return IntStream.range(start, end).boxed()
                .filter(num -> {
                    char[] arr = String.valueOf(num).toCharArray();
                    for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
                        if (arr[i] != arr[j]) {
                            return false;
                        }
                    }
                    return true;
                }).toList();
    }
}
