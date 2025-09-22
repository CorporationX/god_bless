package school.faang.bjs2_88070;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> exampleNumbers = Set.of(1, 2, 3, 4, 5, 6);
        List<String> exampleStrings = List.of("apple", "banana", "avocado", "apricot");

        System.out.println("Пары чисел для 6" + ListOperations.findUniqueNumberPairs(exampleNumbers, 6));

        System.out.println("Отсортированный список строк, начинающихся с 'a' -- "
                + ListOperations.filterByPrefixCharAndSortByLength(exampleStrings, 'a'));

        System.out.println("Двоичный формат чисел от 6 до 1 -- "
                + ListOperations.toBinaryString(new ArrayList<>((exampleNumbers))));

        System.out.println("Сортировка строк по алфавиту -- "
                + ListOperations.filterByAlphabetAndSortByLength(
                        List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));


    }
}
