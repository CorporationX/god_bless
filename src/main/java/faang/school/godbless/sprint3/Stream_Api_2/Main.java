package faang.school.godbless.sprint3.Stream_Api_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class Main {
    //1 На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.

    public Set<List<Integer>> uniqueCouple(List<Integer> list, int n) {
        Set<List<Integer>> res = new HashSet<>();
        list = list.stream().sorted().toList();
        int fast = 0;
        int slow = 0;
        while (slow < list.size() - 1 && list.get(slow) <= n) {
            fast = slow + 1;
            while (list.get(slow) + list.get(fast) <= n) {
                if (list.get(slow) + list.get(fast) == n) {
                    res.add(List.of(list.get(slow), list.get(fast)));
                    break;
                }
                fast++;
            }
            slow++;
        }
        return res;
    }

    public Set<List<Integer>> uniqueCouple2(List<Integer> list, Integer num) {
        return list.stream()
                .filter(e -> list.contains(num - e))
                .map(e -> Arrays.asList(e, num - e))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    //2 На вход получаем мапу с названиями стран и их столицами.
    // Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> countrySort(Map<String, String> map) {
        List<String> res = map.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .map(a -> a.getValue())
                .toList();
        return res;
    }

    //3 Получаем список строк и букву в виде char. Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public static List<String> sortSpecialString(List<String> str, char ch) {
        List<String> res = str.stream()
                .filter(a -> {
                    if (a.length() != 0 || a != null) {
                        return a.toCharArray()[0] == ch;
                    }
                    return false;
                })
                .sorted(Comparator.comparingInt(a -> a.length()))
                .toList();
        return res;
    }

    //5 Получаем список объектов класса Employee, у каждого из которых есть имя,зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Double> middleIncome(List<Employee> list) {
        Map<String, Double> res = list.stream()
                .collect(Collectors.groupingBy(Employee::getPart, Collectors.averagingDouble(Employee::getIncome)));
        return res;
    }

    //6 Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    // и отсортируйте их в порядке возрастания длины строк.
    public static List<String> filterString(List<String> list, String chars) {
        List<String> res = list.stream()
                .filter(s -> {
                    return chars.contains(Arrays.stream(s.toLowerCase().split("")).
                            distinct().
                            sorted().
                            collect(Collectors.joining()));
                }).sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
        return res;
    }

    //7 Написать метод, который преобразует список целых чисел в список строк,
    // где каждое число записано в двоичном виде.
    public static List<Integer> doubleStyle(List<Integer> list) {
        List<Integer> res = list.stream()
                .map(Integer::toBinaryString)
                .map(a -> Integer.parseInt(a))
                .toList();
        return res;
    }

    //8 Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево)
    // в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
    public static List<Integer> numbersPalindrome(Integer start, Integer finish) {
        List<Integer> res = IntStream.range(start, finish+1)
                .filter(n -> {
                    String s = Integer.toString(n);
                    return s.equals(new StringBuilder(s).reverse().toString());
                }).boxed()
                .collect(Collectors.toList());
        return res;
    }

}
