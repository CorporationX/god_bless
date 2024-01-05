package faang.school.godbless;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Application {
    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    static List<String> strings = Arrays.asList(
            "Programming", "Java", "Python", "Database", "Algorithm",
            "Network", "Security", "Artificial", "Intelligence", "Machine",
            "Learning", "Data", "Science", "Web", "Development");
    public static void main(String... args) {
        System.out.println(Application.sumEvenNumbers());
        System.out.println(Application.maxElement());
        System.out.println(Application.averageValue());
        System.out.println(Application.quantityString());
        System.out.println(Application.filterString());
        System.out.println(Application.sortedList());
        System.out.println(Application.checkingList());
        System.out.println(Application.searchMinNumber());
        System.out.println(Application.convertingList());
    }
    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int
    public static int sumEvenNumbers(){
        return numbers.stream()
                     .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
    }
    //Найти максимальный элемент в списке чисел
    public static int maxElement(){
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        return max;
    }
    //Найти среднее значение чисел в списке
    public static double  averageValue(){
         double average = numbers.stream()
                .mapToInt(n ->n)
                .average()
                .getAsDouble();
        return average;
    }
    //Найти количество строк, начинающихся с определённого символа в списке строк
    public static long quantityString(){
        long countString = strings.stream()
                .filter(s -> s.toLowerCase().startsWith(String.valueOf("a").toLowerCase()))
                 .count();
        return countString;
    }
    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    public static List<String> filterString(){
        String substring = "da";
        List<String> filteredString = strings.stream()
                .filter(s -> s.toLowerCase().contains(substring.toLowerCase())).toList();
        return filteredString;
    }
    //Отсортировать список строк по длине
    public static List<String> sortedList() {
        List<String> sortList = strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
        return sortList;
    }
    //Проверить, все ли элементы списка удовлетворяют определённому условию
    public static boolean checkingList(){
        boolean check = strings.stream()
                .allMatch(strings -> strings.length() >= 3);
                return check;
    }
    //Найти наименьший элемент в списке, который больше заданного числа
    public static int searchMinNumber(){
        int min = numbers.stream()
                .filter(n -> n > 3)
                .reduce(Integer.MAX_VALUE, Integer::min);
        return min;
    }
    //Преобразовать список строк в список их длин
    public static List<Integer> convertingList(){
        List<Integer> convertList = strings.stream()
                .map(String::length)
                .collect(toList());
        return convertList;
    }
}
