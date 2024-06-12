package faang.school.godbless.StreamAPI1;

import java.util.List;

public class StaticMetod {
    //    Сумма четных чисел в списке
    public static int sumNumsList(List<Integer> nums) {
        return nums.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum);
    }

    //    Максимальный элемент в списке чисел
    public static int maxNumList(List<Integer> nums) {
        return nums.stream().max((t, u) -> t - u).orElse(0);
    }

    //    Среднее значение чисел в списке
    public static double avgNumsList(List<Integer> nums) {
        return nums.stream().mapToDouble(i -> i).average().orElse(0);
    }

    //    Количество строк, начинающихся с определённого символа в списке строк
    public static long findNumLine(List<String> str, String ch) {
        return str.stream().filter(s -> s.startsWith(ch)).count();
    }

    //    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    public static List<String> filterList(List<String> str, String substring) {
        return str.stream().filter(st -> st.contains(substring)).toList();
    }

    //    Отсортировать список строк по длине;
    public static List<String> sortListString(List<String> str) {
        return str.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    //    Все ли элементы списка удовлетворяют определённому условию
    public static boolean anyMatchTest(List<String> str) {
        return str.stream().anyMatch(s -> s.length() > 2);
    }

    //    Наименьший элемент в списке, который больше заданного числа
    public static int minNumListBigNum(List<Integer> nums, int num) {
        return nums.stream().filter(i -> i > num).min((t, u) -> t - u).orElse(0);
    }

    //    Преобразовать список строк в список их длин
    public static List<Integer> stringConvertLength(List<String> str) {
        return str.stream().map(String::length).toList();
    }
}
