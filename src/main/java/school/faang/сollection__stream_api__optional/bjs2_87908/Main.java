package school.faang.сollection__stream_api__optional.bjs2_87908;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.сollection__stream_api__optional.bjs2_87908.OperationsWithStream.filterAndSort;
import static school.faang.сollection__stream_api__optional.bjs2_87908.OperationsWithStream.filterAndSortByLength;
import static school.faang.сollection__stream_api__optional.bjs2_87908.OperationsWithStream.findUniquePairs;
import static school.faang.сollection__stream_api__optional.bjs2_87908.OperationsWithStream.getNumbersToBinary;
import static school.faang.сollection__stream_api__optional.bjs2_87908.OperationsWithStream.getSortedCapitals;

public class Main {
    public static void main(String[] args) {

        Set<Integer> setNumbers = Set.of(1, 2, 3, 4, 5, 6, 7);
        int sumPair = 7;

        Map<String, String> countriesWithCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> list = List.of("apple", "banana", "cherry", "date", "fig", "grape", "atom");
        char simbol = 'a';

        List<Integer> numbers = List.of(1, 2, 5, 4, 122);

        String alphabet = "abcdefghijklmnopqstuvwxyz"; // без r

        System.out.println("Уникальные пары чисел: " + findUniquePairs(setNumbers, sumPair));
        System.out.println("Список столиц, где страны отсортированы: " + getSortedCapitals(countriesWithCapitals));
        System.out.println("Отсортированный список строк по длине, начинающийся с '" + simbol + "': "
                + filterAndSort(list, simbol));
        System.out.println("Преобразованный список целых чисел в список строк этих чисел в двоичном виде:\n"
                + getNumbersToBinary(numbers));
        System.out.println("Отфильтрованный по " + alphabet + " и отсортированный по длине строк список: "
                + filterAndSortByLength(list, alphabet));
    }
}
