package faang.school.godbless.TrainSteamAPI2;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@UtilityClass
public class StreamMethods {

    // 1. Найдите все уникальные пары чисел, сумма которых равна заданному числу
    public static Set<List<Integer>> uniquePairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pair = numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == sum && j != i)
                        .map(j -> Arrays.asList(Math.min(i, j), Math.max(i, j))))
                .collect(Collectors.toSet());
        return pair;
    }


    // 2. На вход получаем мапу с названиями стран и их столицами.
    // Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public List<String> capitalsSort(Map<String, String> country) {
        List<String> entryStream = country.entrySet().stream()
                .sorted((x, y) -> x.getKey().compareTo(y.getKey()))
                .sorted(Comparator.comparing(Map.Entry::getKey))
                //.sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
        return entryStream;
    }


    // 3. Получаем список строк и букву в виде char.
    // Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public List<String> sortStringsByLength(List<String> strings, Character character) {
        List<String> sortStrings = strings.stream()
                .filter(string -> string.startsWith(character.toString()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        return sortStrings;
    }

    // 4. Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    // Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья
    public Set<List<String>> friendsFriends(Map<String, List<String>> friends) {
        Set<List<String>> pairFriends = friends.entrySet().stream()
                .flatMap(friend1 -> friends.entrySet().stream()
                        .filter(friend2 -> !friend1.getKey().equals(friend2.getKey()))
                        .filter(friend2 -> !friend1.getKey().contains(friend2.getKey()))
                        .filter(friend2 -> friend2.getValue().stream()
                                .anyMatch(friend1.getValue()::contains))
                        .map(friend2 -> { //тут по-другому не смогла сравнить ключи
                            if (friend1.getKey().compareToIgnoreCase(friend2.getKey()) > 0)
                                return Arrays.asList(friend1.getKey(), friend2.getKey());
                            else
                                return Arrays.asList(friend2.getKey(), friend1.getKey());
                        }))
                .collect(Collectors.toSet());
        return pairFriends;
    }

    // 5. Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела.
    // Должна получится map с именем отдела и средней зарплатой.
    public Map<String, Double> averageDepartmentSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

    }

    // 6. Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    // и отсортируйте их в порядке возрастания длины строк.
    public List<String> sortStringsOfLetters(List<String> strings, List<Character> characters) {
        return strings.stream()
                .filter(string -> string.toLowerCase().chars().allMatch(ch -> characters.contains((char) ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 7. Написать метод, который преобразует список целых чисел в список строк,
    // где каждое число записано в двоичном виде.

    public List<String> convertsIntToBinary(List<Integer> integers) {
        return integers.stream()
                .map((Integer::toBinaryString))
                .toList();
    }

    // 8. Написать метод, который найдет все числа-палиндромы
    // (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
    // На вход получаем число для начала диапазона и число для второй границы диапазона.
    public IntStream searchIntPalindrome(int start, int finish) {
        return IntStream.rangeClosed(start, finish)
                .filter(StreamMethods::palindromInt);
    }

    private boolean palindromInt(int num) {
        if (num > 10)
            return String.valueOf(num).equals(new StringBuilder(String.valueOf(num)).reverse().toString());
        else
            return false;
    }

    // 9. Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
    // На вход получаем строку, а вернуть должны список строк.
    public List<String> searchStringPalindrome(String strings) {
        return Arrays.stream(strings.split(" "))
                .filter(StreamMethods::palindromString)
                .toList();
    }

    private boolean palindromString(String string) {
        return String.valueOf(string).toLowerCase()
                .equals(new StringBuilder(String.valueOf(string).toLowerCase()).reverse().toString());

    }


}
