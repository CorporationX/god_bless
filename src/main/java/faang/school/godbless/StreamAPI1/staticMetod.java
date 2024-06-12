package faang.school.godbless.StreamAPI1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class staticMetod {
    //    Сумма четных чисел в списке
    static int sumNumsList(List<Integer> nums) {
        return nums.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum);
    }

    //    Максимальный элемент в списке чисел
    static int maxNumList(List<Integer> nums) {
        Optional<Integer> maxNum = nums.stream().max((t, u) -> t - u);
        return maxNum.orElse(0);
    }

    //    Среднее значение чисел в списке
    static double avgNumsList(List<Integer> nums) {
        OptionalDouble d = nums.stream().mapToDouble(i -> i).average();
        return d.orElse(0);
    }

    //    Количество строк, начинающихся с определённого символа в списке строк
    static long findNumLine(List<String> str, String ch) {
        return str.stream().filter(s -> s.startsWith(ch)).count();
    }

    //    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    static List<String> filterList(List<String> str, String substring) {
        return str.stream().filter(st -> st.contains(substring)).toList();
    }

    //    Отсортировать список строк по длине;
    static List<String> sortListString(List<String> str) {
        return str.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    //    Все ли элементы списка удовлетворяют определённому условию
    static boolean anyMatchTest(List<String> str) {
        return str.stream().anyMatch(s -> s.length() > 2);
    }

    //    Наименьший элемент в списке, который больше заданного числа
    static int minNumListBigNum(List<Integer> nums, int num) {
        Optional<Integer> min = nums.stream().filter(i -> i > num).min((t, u) -> t - u);
        return min.orElse(0);
    }

    //    Преобразовать список строк в список их длин
    static List<Integer> stringConvertLength(List<String> str) {
        return str.stream().map(String::length).toList();
    }
}
