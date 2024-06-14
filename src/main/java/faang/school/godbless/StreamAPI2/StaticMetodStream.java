package faang.school.godbless.StreamAPI2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StaticMetodStream {

    //    уникальные пары чисел, сумма которых равна заданному числу.
    public static List<List<Integer>> sumUnique(List<Integer> nums, int num) {
        return nums.stream()
                .flatMap(i -> nums.stream()
                        .filter(k -> k + i == num)
                        .map(k -> Arrays.stream(new Integer[]{i, k})
                                .sorted()
                                .collect(Collectors.toList())))
                .distinct()
                .collect(Collectors.toList());
    }

    //    Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка
    public static List<String> capitalsList(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    //    Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания
    public static List<String> filterString(List<String> strings, char s) {
        return strings.stream()
                .filter(i -> i.charAt(0) == s)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //    Найдите среднюю зарплату для каждого отдела
    public static Map<String, Double> avgSalaryToDivision(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDivision,
                        Collectors.averagingInt(Employee::getSalary)));
    }

    //    Отфильтруйте строки, которые содержат только буквы заданного алфавита
    public static List<String> filterString(List<String> strings, List<Character> chars) {
        return strings.stream()
                .filter(i -> chars.stream()
                        .anyMatch(j -> i.contains(j.toString())))
                .collect(Collectors.toList());
    }

    //    метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде
    public static List<String> convertsNumInString(List<Integer> binaryNum) {
        return binaryNum.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //    метод, который найдет все числа-палиндромы
    public static List<Integer> filterNumberPalindrom(int start, int finish) {
        return Stream.iterate(start, n -> n + 1).limit(finish - start).filter(i -> {
            String numberStr = String.valueOf(i);
            String reversNumberStr = new StringBuilder(numberStr).reverse().toString();
            return numberStr.equals(reversNumberStr);
        }).toList();
    }

    //    Написать метод, который найдёт все подстроки в строке, которые являются палиндромами. На вход получаем строку, а вернуть должны список строк.
    public static List<String> palindromString(String str) {
        return Arrays.stream(str.split(" ")).filter(i -> {
            String string = i;
            String reversString = new StringBuilder(string).reverse().toString();
            return string.equals(reversString);
        }).toList();
    }
}
