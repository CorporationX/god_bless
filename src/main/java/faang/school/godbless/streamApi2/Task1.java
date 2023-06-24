package faang.school.godbless.streamApi2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу
 */
public class Task1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 5, 9, 8, 3, 3, 6, 4, 2);

        System.out.println(getPairs(integers, 6)); //{1=5, 2=4, 3=3}
    }

    public static Map<Integer, Integer> getPairs(List<Integer> list, int value) {
        Map<Integer, Integer> result = new HashMap<>();

        AtomicInteger lastIndex = new AtomicInteger(list.get(list.size() - 1));

        list.stream().sorted().forEach(n -> {
            for (int i = 0; i < list.size() - 1; i++) {
                Integer integer = list.get(i);
                if (n + integer == value && !result.containsKey(integer)) {
                    result.put(n, integer);
                }
            }
            lastIndex.getAndDecrement();
        });

        return result;
    }
}
