package school.faang.bjs2_89511;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

import static school.faang.bjs2_89511.Practice.allNumsMatchFilter;
import static school.faang.bjs2_89511.Practice.averageValue;
import static school.faang.bjs2_89511.Practice.countStringsStartsWith;
import static school.faang.bjs2_89511.Practice.findMax;
import static school.faang.bjs2_89511.Practice.findMin;
import static school.faang.bjs2_89511.Practice.getStringsLengths;
import static school.faang.bjs2_89511.Practice.sortStringsByLength;
import static school.faang.bjs2_89511.Practice.stringsContainsSubstring;
import static school.faang.bjs2_89511.Practice.sumEvenNumbers;

public class Main {
    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(191, 5, 3, 9, 11);
        List<String> strings = Arrays.asList("Pipipupu", "check", "Hello!", "Java", "Stream", "Strike");
        Predicate<Integer> isEven = n -> n % 2 > 0;

        Optional<Integer> maxValue = findMax(values);
        int sumValue = sumEvenNumbers(values);
        OptionalDouble averageValue = averageValue(values);
        long countString = countStringsStartsWith(strings, 'p');
        List<String> filter = stringsContainsSubstring(strings, "Str");
        List<String> sortedLength = sortStringsByLength(strings);
        boolean test = allNumsMatchFilter(values, isEven);
        int findMin = findMin(values, 10);
        List<Integer> stringInLength = getStringsLengths(strings);

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
