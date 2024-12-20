package school.faang.task_47464;

import java.net.SocketOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // task 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int targetSum = 7;
        List<int[]> uniquePairs = CollectionOperations.findUniquePairs(numbers, targetSum);

        System.out.println("Uniques pairs:");
        System.out.print("[");
        uniquePairs.forEach(pair -> System.out.print("(" + pair[0] + "," + pair[1] + ")"));
        System.out.print("]");

        // task2
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("USA", "Washington");
        countryCapitalMap.put("Germany", "Berlin");
        List<String> sortedCapital = CollectionOperations.capitalList(countryCapitalMap);
        System.out.println("Capital, sorted by countries:");
        System.out.println(sortedCapital);

        // task3
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> sortedList = CollectionOperations.filterAndSortString(strings, 'a');
        System.out.println("Sorted string list: " + sortedList);

        //task4
        System.out.println("Array of integer to array of binary: "
                + CollectionOperations.listOfNumberToListOfBinary(numbers));

        //task5
        List<String> unsortedStrings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = CollectionOperations.filterByAlphabetAndSortStrings(unsortedStrings, alphabet);
        System.out.println("Filtered and sorted strings: " + result);
    }


    // Пример использования методов:
//        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
//    List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
//        System.out.println("Максимум: " + ListOperations.findMax(numbers));
//        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
//        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
//        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
//        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
//        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
//        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
//        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
}
