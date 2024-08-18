package faang.school.godbless.StreamAPI2;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//#1
//public class Main {
//    public static void main(String[] args) {
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,21);
//        int targetSum = 20;
//        List<List<Integer>> pairs = findPairsWithSum(numbers, targetSum);
//        System.out.println("Pairs: " + pairs);
//    }
//
//    public static List<List<Integer>> findPairsWithSum(List<Integer> numbers, int targetSum) {
//        Set <Integer> seen = new HashSet<>();
//        return numbers.stream()
//                .flatMap(n -> {
//                    int complement = targetSum - n;
//                    if (seen.contains(complement)) {
//                        return Stream.of(Arrays.asList(complement, n));
//                    } else {
//                        seen.add(n);
//                        return Stream.empty();
//                    }
//                })
//                .collect(Collectors.toList());
//    }
//}

//#2
public class Main {
    public static void main(String[] args) {
        Map<String, String> countryCapitals = Map.of(
                "France", "Paris",
                "Germany", "Berlin",
                "Italy", "Rome",
                "Spain", "Madrid"
        );
        List<String> sortedCapitals = getSortedCapitals(countryCapitals);
        System.out.println("Sorted capitals: " + sortedCapitals);
    }

    public static List<String> getSortedCapitals(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
