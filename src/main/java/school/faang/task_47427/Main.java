package school.faang.task_47427;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> strings = Arrays.asList("banana", "apple", "avocado", "apricot");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Уникальные пары чисел, сумма которых равна 7: "
                + ListOperations.findUniquePairs(numbers, 7));
        System.out.println("Список названий столиц по алфавиту: " + ListOperations.getSortedCapitals(countries));
        System.out.println("Строки, которые начинаются с заданного символа 'a', отсортированные по длине: "
                + ListOperations.filterAndSort(strings, 'a'));
        System.out.println("Список строк, где каждое число записано в двоичном виде: "
                + ListOperations.convertToBinary(numbers));
        System.out.println("Строки, которые содержат только буквы из заданного алфавита, отсортированные по длине: "
                + ListOperations.filterAndSortByLength(strings, alphabet));

    }
}
