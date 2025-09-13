package school.faang.bjs2_89511;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static school.faang.bjs2_89511.Practice.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(191, 5, 3, 9, 11);
        List<String> strings = Arrays.asList("Pipipupu", "check", "Hello!", "Java", "Stream", "Strike");
        Predicate<Integer> isEven = n -> n % 2 > 0;

        int maxValue = findMax(values);
        int sumValue = sumValid(values);
        double averageValue = averageValue(values);
        long countString = countString(strings, 'p');
        List<String> filter = filter(strings, "Str");
        List<String> sortedLength = sort(strings);
        boolean test = test(values, isEven);
        int findMin = findMin(values, 10);
        List<Integer> stringInLength = list(strings);

        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Сумма значений: " + sumValue);
        System.out.println("Среднее значение: " + averageValue);
        System.out.println("Столько слов начинаются с символа: " + countString);
        System.out.println("Фильтр подстроки: " + filter);
        System.out.println("Сортировка по длине: " + sortedLength);
        System.out.println("Удовлетворют условию? " + test);
        System.out.println("Находим минимальное, которое удовлетворяет условию: " + findMin);
        System.out.println("Длины строк: " + stringInLength);
    }
}
