package faang.school.godbless.streamApi2;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Написать метод, который найдет все числа-палиндромы
 * (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
 * На вход получаем число для начала диапазона и число для второй границы диапазона.
 */
public class Task8 {
    public static void main(String[] args) {
        List<Integer> range = IntStream.rangeClosed(1, 10000)
                .boxed().toList();

        System.out.println(getPalindromes(range));
    }

    public static List<Integer> getPalindromes(List<Integer> list) {
        return list.stream().filter(i -> {
            String s = String.valueOf(i);
            return s.contentEquals(new StringBuilder(s).reverse());
        }).toList();
    }
}
