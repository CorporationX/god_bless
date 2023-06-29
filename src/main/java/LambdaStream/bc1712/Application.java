package LambdaStream.bc1712;

import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    //    Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    static public int sum(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    //    Найти максимальный элемент в списке чисел;
    static public int max(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).max().orElseThrow(null);
//        return nums.stream().max(Comparator.naturalOrder());
    }

    //    Найти среднее значение чисел в списке;
    static public double average(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).average().orElseThrow(null);
    }

    //    Найти количество строк, начинающихся с определённого символа в списке строк;
    static public long countString(List<String> strings) {
        return strings.stream().filter(s -> s.startsWith("A")).count();
    }

    //    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    static public List<String> containsString(List<String> strings) {
        return strings.stream().filter(s -> s.contains("n")).toList();
    }

    //    Отсортировать список строк по длине;
    static public List<String> lengthString(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    //    Проверить, все ли элементы списка удовлетворяют определённому условию;
    static public boolean allMatch(List<String> strings, int length) {
        return strings.stream().allMatch(s -> s.length() > length);
    }

    //    Найти наименьший элемент в списке, который больше заданного числа;
    static public int min(List<Integer> nums, int number) {
        return nums.stream().filter(i -> i > number).mapToInt(Integer::intValue).min().orElseThrow(null);
//        return nums.stream().filter(i -> i > number).min(Comparator.naturalOrder());
    }

    //    Преобразовать список строк в список их длин.
    static public List<Integer> listLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
