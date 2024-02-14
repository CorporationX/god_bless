package StreamAPI2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void first(List<Integer> list, int number){ // Задание 1 - На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу. Порядок следования неважен.

        List<List<Integer>> pairs = list.stream()
                .flatMap(i -> list.stream()
                        .filter(j -> i + j == number && list.indexOf(i) < list.indexOf(j))
                        .map(j -> List.of(i, j)))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Задание 1 - " + pairs);
    }

    public static void second(Map<String, String> countries){ // Задание 2 - На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
        List<String> sortedCountries = countries.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> capitals = sortedCountries.stream()
                .map(countries::get)
                .collect(Collectors.toList());

        System.out.println("Задание 2 - " + capitals);
    }

    public static void third(List<String> list, char letter){ // Задание 3 - Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
        List<String> sortedStrings = list.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted((a, b) -> a.length() - b.length())
                .collect(Collectors.toList());

        System.out.println("Задание 3 - " + sortedStrings);
    }

    public static List<List<String>> findCommonFriends(Map<String, List<String>> friendsMap) { // Задание 4 - Дана мапа, где ключами являются имена людей, а значениями — списки имен их друзей. Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья. Считаем, что все имена уникальные.
        List<List<String>> list = friendsMap.entrySet().stream()
                .flatMap(entry1 ->
                        friendsMap.entrySet().stream()
                                .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                                .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                                .filter(entry2 -> haveCommonFriends(entry1.getValue(), entry2.getValue()))
                                .map(entry2 -> Arrays.asList(entry1.getKey(), entry2.getKey()))
                )
                .distinct()
                .collect(Collectors.toList());

        return removeDuplicates(list);
    }
    public static boolean haveCommonFriends(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return !set1.isEmpty();
    }
    public static List<List<String>> removeDuplicates(List<List<String>> list) {
        Set<List<String>> set = new HashSet<>();
        return list.stream()
                .filter(e -> set.add(e) && set.add(Arrays.asList(e.get(1), e.get(0))))
                .collect(Collectors.toList());
    }

    static class Employee { // Задание 5 - Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел. Найдите среднюю зарплату для каждого отдела. Должна получится Map с названием отдела и средней зарплатой.
        private String name;
        private double salary;
        private String department;

        public Employee(String name, double salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }
    }

    public static void AverageSalary(List<Employee> employees){
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Задание 5 - " + averageSalaryByDepartment);
    }

    public static List<String> filterAndSortStrings(List<String> inputStrings, String alphabet) { // Задание 6 - Дан список строк и массив букв, представляющий алфавит. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
        List<String> filteredAndSorted = inputStrings.stream()
                .filter(s -> s.toLowerCase().chars().allMatch(c -> alphabet.contains(String.valueOf((char) c))))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        return filteredAndSorted;
    }

    public static List<String> convertToBinaryStrings(List<Integer> numbers) { // Задание 7 - Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromesInRange(int start, int end) { // Задание 8 - Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
        List<Integer> palindromes = new ArrayList<>();

        for (int number = start; number <= end; number++) {
            if (isPalindrome(number)) {
                palindromes.add(number);
            }
        }

        return palindromes;
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static List<String> findPalindromicSubstrings(String input) { // Задание 9 - Написать метод, который найдёт все подстроки в строке, которые являются палиндромами. На вход получаем строку, а вернуть должны список строк.
        List<String> palindromicSubstrings = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            expandAroundCenter(input, i, i, palindromicSubstrings);
            expandAroundCenter(input, i, i + 1, palindromicSubstrings);
        }

        return palindromicSubstrings;
    }

    private static void expandAroundCenter(String input, int left, int right, List<String> result) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            if (left != right) {
                result.add(input.substring(left, right + 1));
            }
            left--;
            right++;
        }
    }

    public static List<Integer> findPerfectNumbersInRange(int start, int end) { // Задание 10 - Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
        return IntStream.rangeClosed(start, end)
                .filter(Main::isPerfectNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }

        return sum == number;
    }

    public static void main(String args[]){
        //Создание коллекций для каждого задания
        List<Integer> list = Arrays.asList(1,9,3,6,4,5); //Коллекция задание 1

        Map<String, String> countries = new HashMap(); //Коллекция задание 2
        countries.put("France", "Paris");
        countries.put("Germany", "Berlin");
        countries.put("England", "London");
        countries.put("Z", "Rome");
        countries.put("A", "Madrid");

        List<String> list2 = Arrays.asList("Бар", "Мама", "Книга", "Апельсин", "Яблоко", "Корабль", "Гирлянда", "Орел","Котик"); //Коллекция задание 3

        Map<String, List<String>> friendsMap = new HashMap<>(); //Коллекция задание 4
        friendsMap.put("Alice", Arrays.asList("James", "Charlie", "David"));
        friendsMap.put("James", Arrays.asList("Alice", "Gregory"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "David"));
        friendsMap.put("David", Arrays.asList("Alice", "Charlie"));
        friendsMap.put("Gregory", Arrays.asList("James"));
        List<List<String>> list4 = findCommonFriends(friendsMap);

        List<Employee> employees = Arrays.asList( //Коллекция задание 5
                new Employee("Alice", 50000, "HR"),
                new Employee("Gregory", 60000, "IT"),
                new Employee("Charlie", 75000, "HR"),
                new Employee("David", 80000, "IT"),
                new Employee("Eva", 55000, "Finance"),
                new Employee("James", 70000, "Finance")
        );

        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat", "041"); //Коллекция задание 6
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = filterAndSortStrings(inputStrings, alphabet);

        List<Integer> numbers = List.of(5, 10, 15, 20); //Коллекция задание 7
        List<String> binaryStrings = convertToBinaryStrings(numbers);

        List<Integer> palindromes = findPalindromesInRange(1, 999); //Коллекция задание 8

        List<String> palindromicSubstrings = findPalindromicSubstrings("ababa"); //Коллекция задание 9

        List<Integer> perfectNumbers = findPerfectNumbersInRange(1, 999); //Коллекция задание 10




//Вывод всего
        first(list, 10); //Вывод задание 1

        second(countries); //Вывод задание 2

        third(list2, 'К'); //Вывод задание 3


        System.out.println("Задание 4 - " + list4); //Вывод задание 4

        AverageSalary(employees); //Вывод задание 5

        System.out.println("Задание 6 - " + result); //Вывод задание 6

        System.out.println("Задание 7 - " + binaryStrings); //Вывод задание 7

        System.out.println("Задание 8 - Palindromes in the range [" + 1 + ", " + 999 + "]: " + palindromes); //Вывод задание 8

        System.out.println("Задание 9 - Palindromic Substrings: " + palindromicSubstrings); //Вывод задание 9

        System.out.println("Задание 10 - Perfect Numbers in the range [" + 1 + ", " + 999 + "]: " + perfectNumbers); //Вывод задание 10

    }
}
