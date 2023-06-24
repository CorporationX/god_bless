package faang.school.godbless.streamApi2;

import java.util.List;

/**
 * Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу)
 * в заданном диапазоне.
 * На вход получаем число для начала диапазона и число для второй границы диапазона.
 */
public class Task10 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(6, 28, 496, 8128, 33550336, 98, 102563);

        List<Integer> list = integers.stream().filter(integer -> {
            int sum = 0;
            for (int i = 1; i <= integer / 2; i++) {
                if (integer % i == 0) {
                    sum += i;
                }
            }
            return sum == integer;
        }).toList();

        System.out.println(list);
    }
}
