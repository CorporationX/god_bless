package streamAPITraning1;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        StaticMethods staticMethods = new StaticMethods();

        List<Integer> nums = List.of(1, 2, 3, 4, 50, 6, 7, 8, 9);

        System.out.println("Сумма четных чисел в списке: " + staticMethods.getSumOfEvenNums(nums));
        System.out.println("Максимальное число в списке: " + staticMethods.getMax(nums));
        System.out.println("Среднее значение чисел в списке: " + staticMethods.getAverage(nums));
        System.out.println("Наименьший элемент в списке, который больше 5ти: " + staticMethods.getMinOfMoreThanNumber(nums, 5));

        List<String> lines = List.of("bob", "train", "bober", "bebebe", "boblin", "abc", "ebobo");

        String substring = "bob";
        System.out.println("Количество строк, начинающихся с \"" + substring + "\": " + staticMethods.getCountLinesOfStaringWithSubstring(lines, substring));
        System.out.println("Список строк, содержащих подстроку \"" + substring + "\": " + staticMethods.getLinesWithSubstring(lines, substring));
        System.out.println("Список отсортированный по длине: " + staticMethods.sortByLength(lines));
        Predicate<String> predicate = (line) -> !(line.length() > 3);
        System.out.println("Результат проверки все ли элементы списка имеют длину больше 3х: " + !staticMethods.checkCondition(lines, predicate));
        System.out.println("Список длин строк: " + staticMethods.convertStringsToTheirLengths(lines));
    }
}