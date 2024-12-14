package school.faang.streamapi_two;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionMethods {
    public Set<List<Integer>> findUniquePairs(List<Integer> list, int sumOfPair) {
        Set<List<Integer>> foundPairs = new HashSet<>();
        Set<Integer> inputList = new HashSet<>();

        inputList.addAll(list);
        foundPairs = inputList.stream()
                .filter(number -> inputList.contains(sumOfPair - number))
                .map(number -> Arrays.asList(number, sumOfPair - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return foundPairs;
    }

    public List<String> sortCapitalByAlphabet(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }



}
