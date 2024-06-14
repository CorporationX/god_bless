package faang.school.godbless.BJS2_10664;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.averagingInt;

public class Main {
    public static void main(String[] args) {
        //findPairs
//        List<int[]> firstTask = findPairs(List.of(1, 9, 3, 6, 4, 5), 10);
//        firstTask.stream().forEach(e -> System.out.println(Arrays.toString(e)));


        ////findCountries
//        Map<String, String> countries = Map.of(
//                "Russia", "Moscow",
//                "Netherlands", "Amsterdam",
//                "UK", "London",
//                "Czech", "Prague");
//
//        findCountries(countries).stream().forEach(e -> System.out.println(e));

        //filterStrings
        //filterStrings(List.of("abc", "bca", "ang", "aaaa", "abcdswf"), 'a').stream().forEach(e -> System.out.println(e));

        //findAllPairs
//        Map<String, List<String>> friends = new HashMap<>();
//        friends.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
//        friends.put("Bob", Arrays.asList("Alice", "Eve"));
//        friends.put("Charlie", Arrays.asList("Alice", "David"));
//        friends.put("David", Arrays.asList("Alice", "Charlie"));
//        friends.put("Eve", Arrays.asList("Bob", "Trump"));
//
//        findAllPairs(friends).stream().forEach(e -> System.out.println(e));

        //findAvarageSalaryByDepartment

//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee("test1", 10_000, "IT"));
//        list.add(new Employee("test2", 25_000, "IT"));
//        list.add(new Employee("test3", 30_000, "IT"));
//
//        list.add(new Employee("test5", 10_000, "Art"));
//        list.add(new Employee("test6", 25_000, "Art"));
//        list.add(new Employee("test7", 40_000, "Art"));
//
//        list.add(new Employee("test8", 10_000, "Sport"));
//        list.add(new Employee("test9", 25_000, "Sport"));
//        list.add(new Employee("test10", 40_000, "Sport"));
//
//        findAvarageSalaryByDepartment(list).entrySet().stream().forEach((k) -> System.out.println(k));

        //filterAlphabet
//        filterAlphabet(List.of("apple", "banana", "123", "dog", "cat"), "abcdefghijklmnopqrstuvwxyz").stream()
//                .forEach((k) -> System.out.println(k));

        //convertToBinaryView
        // convertToBinaryView(List.of(1, 2, 3)).stream().forEach((k) -> System.out.println(k));

        //findPalindromes
        //findPalindromes(10, 100).stream().forEach((k) -> System.out.println(k));
    }

    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу. Порядок следования неважен.
    //Пример: Input List: [1, 9, 3, 6, 4, 5]
    //Target Sum: 10
    //Pairs: [[1, 9], [6, 4]]
    public static List<int[]> findPairs(List<Integer> list, int target) {
        return IntStream.range(0, list.size() - 1).boxed()
                .filter(value -> (list.get(value) + list.get(++value)) == target)
                .map(value -> new int[]{list.get(value), list.get(++value)}).collect(Collectors.toList());
    }

    //На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> findCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(value -> value.getValue())
                .toList();
    }

    //Получаем список строк и букву в виде char.
    // Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> filterStrings(List<String> strings, char letter) {
        return strings.stream().filter(line -> line.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки имен их друзей.
    // Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья. Считаем, что все имена уникальные.
    public static List<List<String>> findAllPairs(Map<String, List<String>> people) {
        return people.entrySet().stream()
                .flatMap(entry1 -> people.entrySet().stream()
                        .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                        .map(entry2 -> {
                            List<String> pair = new ArrayList<>(List.of(entry1.getKey(), entry2.getKey()));
                            pair.sort(Comparator.naturalOrder()); // Сортировка имен в паре
                            return pair;
                        })
                )
                .distinct()
                .toList();
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела. Должна получится Map с названием отдела и средней зарплатой.
    public static Map<String, Double> findAvarageSalaryByDepartment(List<Employee> employee) {
        return employee.stream()
                .collect(Collectors.groupingBy(e ->
                        e.getDepartment(), averagingInt(Employee::getSalary)
                ));
    }


    //    Дан список строк и массив букв, представляющий алфавит.
//    Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
//    Пример ввода:
//    Input Strings: [apple, banana, 123, dog, cat]
//    Alphabet: abcdefghijklmnopqrstuvwxyz
//    Output: [dog, cat, apple, banana]
    public static List<String> filterAlphabet(List<String> strings, String letters) {

        return strings.stream().
                filter(e -> e.toLowerCase().chars().mapToObj(i -> (char) i)
                        .anyMatch(i -> letters.contains(String.valueOf(i))))
                .sorted(Comparator.comparing(String::length)).toList();
    }


    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.

    public static List<String> convertToBinaryView(List<Integer> integers) {
        return integers.stream().map(e -> Integer.toBinaryString(e)).toList();

    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
    // в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.range(start, end).boxed()
                .filter(x -> {
                    String a = new StringBuffer(String.valueOf(x)).reverse().toString();
                    return a.equals(String.valueOf(x));
                }).toList();

    }


}
