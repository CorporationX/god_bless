package faang.school.godbless.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionHandler {


    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    //Порядок следования неважен.
    public static List<List<Integer>> findPairsBySum(List<Integer> numbers, int sum) {

        List<List<Integer>> uniquePairs = new ArrayList<>();

        numbers.forEach(currentNumber -> numbers.stream()
                .filter(number -> sum - currentNumber == number)
                .filter(number -> uniquePairs.stream().noneMatch(integers -> integers.contains(currentNumber)))
                .forEach(integer -> uniquePairs.add(Arrays.asList(currentNumber, integer))));
        return uniquePairs;
    }

    //На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту,
    //а затем выведите названия их столиц в виде списка.
    public static List<String> sortCountriesByCapital(Map<String, String> countries) {

        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    //Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.

    public static List<String> filterByLetter(List<String> strings, char letter) {
        return strings.stream()
                .map(String::toLowerCase)
                .filter(str -> str.startsWith(String.valueOf(letter).toLowerCase()))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки имен их друзей. Найдите
    // все пары людей, которые не являются друзьями, но у них есть общие друзья. Считаем, что все имена уникальные.

    public static List<List<String>> findCommonFriends(Map<String, List<String>> friends) {

        List<List<String>> pairs = new ArrayList<>();
        List<List<String>> sortedPairs = new ArrayList<>();
        friends.keySet().forEach(currentPerson ->
                friends.keySet().stream()
                        .filter(friend -> !friend.equals(currentPerson))
                        .filter(friend -> !friends.get(currentPerson).contains(friend))
                        .filter(friend -> new HashSet<>(friends.get(friend)).containsAll(friends.get(currentPerson)))
                        .forEach(otherPerson -> pairs.add(Arrays.asList(currentPerson, otherPerson)))
        );

        pairs.forEach(strings -> {
            strings.sort(Comparator.naturalOrder());
            sortedPairs.add(strings);
        });

        return sortedPairs.stream().distinct().toList();
    }


    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела. Должна получится Map с названием отдела и средней зарплатой.

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Дан список строк и массив букв, представляющий алфавит. Отфильтруйте строки, которые содержат только буквы
    // заданного алфавита, и отсортируйте их в порядке возрастания длины строк.

    public static List<String> filterByAlphabet(List<String> strings, String[] alphabet) {

        return strings.stream()
                .filter(str -> str.chars().allMatch(ch -> String.join(", ", alphabet).indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
    // в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.

    public static List<Integer> findPalindromes(int start, int end) {

        return IntStream.rangeClosed(start, end)
                .filter(number -> String.valueOf(number).contentEquals(new StringBuilder(String.valueOf(number)).reverse()))
                .boxed()
                .collect(Collectors.toList());
    }
}