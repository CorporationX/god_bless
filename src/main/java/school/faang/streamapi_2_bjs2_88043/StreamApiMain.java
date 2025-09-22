package school.faang.streamapi_2_bjs2_88043;

import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.streamapi_2_bjs2_88043.StreamApi.convertToBinary;
import static school.faang.streamapi_2_bjs2_88043.StreamApi.filterAndSort;
import static school.faang.streamapi_2_bjs2_88043.StreamApi.filterAndSortByLength;
import static school.faang.streamapi_2_bjs2_88043.StreamApi.findPairsNumbers;
import static school.faang.streamapi_2_bjs2_88043.StreamApi.getSortedCapitals;

@ToString
public class StreamApiMain {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<List<Integer>> pairs = findPairsNumbers(numbers, 7);
        System.out.println(pairs);
        System.out.println("------------------------------");

        Map<String, String> countrys = new HashMap<>();
        countrys.put("Russia", "Moscow");
        countrys.put("USA", "Washington");
        countrys.put("Germany", "Berlin");
        System.out.println(countrys);

        List<String> sortCoyntrys = getSortedCapitals(countrys);
        System.out.println(sortCoyntrys);
        System.out.println("--------------------------------");

        List<String> list = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(list);
        List<String> sortList = filterAndSort(list, 'a');
        System.out.println(sortList);
        System.out.println("--------------------------------");

        List<Integer> numberss = List.of(1, 2, 3, 4, 21);
        System.out.println(numberss);
        List<String> converrtNumberss = convertToBinary(numberss);
        System.out.println(converrtNumberss);
        System.out.println("--------------------------------");

        List<String> nummbers = List.of("apple", "banana", "cherry2", "date", "fig", "grape");
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(nummbers);
        List<String> sortNummbers = filterAndSortByLength(nummbers, alphabets);
        System.out.println(sortNummbers);
    }
}