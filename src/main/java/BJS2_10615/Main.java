package BJS2_10615;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 9, 3, 6, 4, 5);
        System.out.println(sumUnique(integers, 10));

        Map<String, String> countryAndCapital = Map.of(
                "Russia", "Moscow",
                "Italy", "Rome",
                "Zimbabwe", "Harare");
        System.out.println(sortedCounty(countryAndCapital));

        System.out.println(filterAndSortStringsByLetter(List.of("AYAYAYA", "CatSadge"), 'a'));

        List<String> strings = List.of("apple", "ank", "car");
        String alphabet = "abcdnkr";

        System.out.println(filterAndSortString(strings, alphabet));

        System.out.println(findNonFriendsWithCommonFriends(Map.of(
                "Yaroslav", List.of("Dima", "Kirill", "Ella", "Ars"),
                "Kirill", List.of("Dima", "Ella"))));

        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println(convertToBinary(nums));

        System.out.println(findPalindrome(10, 150));

        System.out.println(findPrefectNumbers(1, 30));
    }

    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    public static List<List<Integer>> sumUnique(List<Integer> nums, int number) {
        Set<Integer> used = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();
        nums.stream().distinct().forEach(num -> {
            Integer target = number - num;
            used.add(num);
            if (nums.contains(target) && !used.contains(target)) {
                used.add(target);
                pairs.add(List.of(num, target));
            }
        });
        return pairs;
    }

    //  На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> sortedCounty(Map<String, String> countriesAndCapital) {

        return countriesAndCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //  Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> filterAndSortStringsByLetter(List<String> strings, char letter) {
        return strings.stream()
                .map(String::toLowerCase)
                .filter(string -> string.charAt(0) == Character.toLowerCase(letter))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

//  Дана мапа, где ключами являются имена людей, а значениями — списки их друзей. Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static List<List<String>> findNonFriendsWithCommonFriends(Map<String, List<String>> informationAboutFriends) {
        return informationAboutFriends.keySet().stream()
                .flatMap(person -> informationAboutFriends.keySet().stream()
                        .filter(person2 -> !informationAboutFriends.get(person).contains(person2) && !person.equals(person2))
                        .flatMap(person2 -> {
                            Set<String> commonFriends = new HashSet<>(informationAboutFriends.get(person));
                            commonFriends.retainAll(informationAboutFriends.get(person2));

                            return commonFriends.isEmpty() ? Stream.empty() : Stream.of(List.of(person, person2));
                        })).toList();
    }

    //  Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел. Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getName, Collectors.averagingDouble(Employee::getSalary)));
    }

    //    Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
    public static List<String> filterAndSortString(List<String> strings, String alphabet) {
        Set<Integer> chars = alphabet.chars().boxed().collect(Collectors.toSet());
        return strings.stream()
                .filter(string -> string.chars().allMatch(chars::contains))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    //    Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //    Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> findPalindrome(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Main::isPalindrome)
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(int num) {
        String number = Integer.toString(num);
        return number.contentEquals(new StringBuilder(number).reverse());
    }

    //    Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> findPrefectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Main::ifPrefect)
                .boxed()
                .toList();
    }

    private static boolean ifPrefect(int number) {
        return IntStream.rangeClosed(1, number / 2)
                .filter(i -> number % i == 0)
                .sum() == number;
    }
}