package school.faang.task_46820;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<String> words = Arrays.asList("Понедельник", "Вторник", "Среда", "Четверг", "Пятница",
                "Суббота", "Воскресенье", "Вторник");
        System.out.println(WorkingWithValues.findEvenSum(number));
        System.out.println(WorkingWithValues.findMax(number));
        System.out.println(WorkingWithValues.findAverageValue(number));
        System.out.println(WorkingWithValues.countStringsStartingWith(words, 'П'));
        WorkingWithValues.filterBySubstring(words, "Вторник").stream()
                .forEach(System.out::println);
        System.out.println("");
        WorkingWithValues.sortByLength(words).stream()
                .forEach(System.out::println);
        System.out.println(WorkingWithValues.satisfyTheCondition(number, x -> x > 0));
        System.out.println(WorkingWithValues.findMinGreaterThan(number, 5));
        System.out.println("");
        WorkingWithValues.mapToLengths(words).stream()
                .forEach(System.out::println);


    }
}
