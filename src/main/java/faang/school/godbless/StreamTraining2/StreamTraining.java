package faang.school.godbless.StreamTraining2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTraining {
    //На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
    public static Set<List<Integer>> uniquePairs(List<Integer> list, Integer num) {
        return list.stream()
                .filter(e -> list.contains(num - e))
                .map(e -> Arrays.asList(e, num - e))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    //На вход получаем мапу с названиями стран и их столицами. Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> capitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue)
                .toList();
    }

    //Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> sortedStrings(List<String> list, char ch) {
        return list.stream()
                .filter(str -> str.toLowerCase().startsWith(String.valueOf(ch).toLowerCase()))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей. Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static Set<List<String>> friendsOfFriends(Map<String, List<String>> friendList) {
        return friendList.keySet()
                .stream()
                .flatMap(name1 -> friendList.keySet()
                        .stream()
                        .filter(name2 -> !friendList.get(name1).contains(name2)
                                && !friendList.get(name2).contains(name1)
                                && friendList.get(name1).stream().anyMatch(friendList.get(name2)::contains))
                        .map(name2 -> Arrays.asList(name2, name1))
                        .filter(list -> !Objects.equals(list.get(0), list.get(1)))
                        .peek(Collections::sort)
                ).collect(Collectors.toSet());
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел. Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> averageSalary(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
    public static List<String> alphabetContains(List<String> list, String alphabet) {
        return list.stream()
                .filter(str -> str.replaceAll(" ", "").toLowerCase().matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
    public static List<String> numToBinary(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    //Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> numPalindromes(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(num -> {
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
                    String str = stringBuilder.toString();
                    String reversed = stringBuilder.reverse().toString();
                    return str.equals(reversed);
                })
                .boxed()
                .toList();
    }

    //Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> perfectNumbers(int start, int end) {
        return IntStream.range(start, end + 1)
                .filter(num -> IntStream.range(1, num).filter(divisor -> num % divisor == 0).sum() == num)
                .boxed()
                .toList();
    }
}
