package faang.school.godbless.stream_practise2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StreamPractise {

    //    На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.

    public static List<String> findUniqueNumberPairsWithSum(List<Integer> numbers, int numberToCompare) {
        return numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 != num2 && num1 + num2 == numberToCompare)
                        .map(num2 -> {
                            int smallerNum = Math.min(num1, num2);
                            int largerNum = Math.max(num1, num2);
                            return smallerNum + " + " + largerNum;
                        }))
                .distinct()
                .collect(Collectors.toList());
    }

//    На вход получаем мапу с названиями стран и их столицами.
//    Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.

    public static List<String> sortAlphabeticallyCountriesNames(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

//    Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
//    и отсортируйте их по длине в порядке возрастания, и верните список этих строк.

    public static List<String> filterAndSortStringsByStartingLetter(List<String> strings, char startingLetter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(startingLetter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

//    Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
//    Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.

    public static List<List<String>> findNonFriendPairsWithCommonFriends(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(entry -> friends.entrySet().stream()
                        .filter(e -> !entry.getKey().equals(e.getKey()))
                        .filter(e -> !entry.getValue().contains(e.getKey()))
                        .filter(e -> haveCommonFriends(entry.getValue(), e.getValue()))
                        .map(e -> {
                            List<String> pair = new ArrayList<>(List.of(entry.getKey(), e.getKey()));
                            pair.sort(String::compareTo);
                            return pair;
                        })
                )
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean haveCommonFriends(List<String> friends1, List<String> friends2) {
        return friends1.stream()
                .anyMatch(friends2::contains);
    }
//    Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
//    Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.

    public static Map<String, Double> getAverageSalaryForDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

//    Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
//    и отсортируйте их в порядке возрастания длины строк.

    public static List<String> filterAndSortStrings(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(str -> containsOnlyAlphabet(str, alphabet))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private static boolean containsOnlyAlphabet(String str, String alphabet) {
        String lowerCaseStr = str.toLowerCase();

        for (char c : lowerCaseStr.toCharArray()) {

            if (!alphabet.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }

//    Написать метод, который преобразует список целых чисел в список строк,
//    где каждое число записано в двоичном виде.

    public static List<String> convertToBinaryList(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    //    Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
    //    в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.

    public static List<Integer> findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(StreamPractise::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int number) {
        String numString = String.valueOf(number);
        String reversedString = new StringBuilder(numString).reverse().toString();
        return numString.equals(reversedString);
    }
}
