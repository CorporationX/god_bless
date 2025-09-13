package school.faang.bjs2_88282;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(ListOperations.countEvenNumbersSum(numbers));
        System.out.println(ListOperations.maxNumber(numbers));
        System.out.println(ListOperations.averageValue(numbers));
        List<String> strings = List.of("Мама", "Папа", "Яма", "Спортивная", "Семья");
        System.out.println(ListOperations.countStringsStartWithSymbol(strings, 'С'));
        System.out.println(ListOperations.selectStringsWithSubstring(strings, "ма"));
        System.out.println(ListOperations.sortByLength(strings));
        Predicate<Integer> predicate = x -> {
            return x < 8;
        };
        System.out.println(ListOperations.checkCondition(numbers, predicate));
        System.out.println(ListOperations.findMinSatisfyCondition(numbers, 4));
        System.out.println(ListOperations.convertListStringToListLength(strings));
    }
}
