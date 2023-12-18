package StreamAPI1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(2);
        numbers.add(-4);
        numbers.add(3);
        numbers.add(123);
        numbers.add(9);
        numbers.add(-56);

        System.out.println(findOddSum(numbers));
        System.out.println(findMax(numbers));
        System.out.println(findAverage(numbers));


        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("asdf");
        strings.add("123");
        strings.add("Hello");
        strings.add("asdf");

        System.out.println(countStingsStartingWith(strings, "H"));
        System.out.println(filterBySubstring(strings, "sd"));
        System.out.println(sortByLength(strings));
        System.out.println(checkByCondition(strings, (string) -> string.length() < 10));

        System.out.println(findSmallerButBigger(numbers, 8));

        System.out.println(mapStingsToLenghs(strings));
    }

    //    Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int findOddSum(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    //    Найти максимальный элемент в списке чисел;
    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparingInt(number -> number)).orElse(0);
    }


    //    Найти среднее значение чисел в списке;
    public static Double findAverage(List<Integer> numbers) {
        OptionalDouble result = numbers.stream()
                .mapToInt(Integer::intValue).average();
        return result.orElse(0);
    }


    //    Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long countStingsStartingWith(List<String> strings, String startSting) {
        return strings.stream().filter(string -> string.startsWith(startSting)).count();
    }

    //    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream().filter(string -> string.contains(substring)).toList();
    }

    //    Отсортировать список строк по длине;
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    //    Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static Boolean checkByCondition(List<String> strings, Predicate<String> predicate) {
        return strings.stream().allMatch(predicate);
    }

    //    Найти наименьший элемент в списке, который больше заданного числа;
    public static Optional<Integer> findSmallerButBigger(List<Integer> numbers, int number) {
        return numbers.stream().filter((tempNumber) -> tempNumber > number)
                .min(Comparator.comparingInt(number2 -> number2));
    }

    //    Преобразовать список строк в список их длин.
    public static List<Integer> mapStingsToLenghs(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
