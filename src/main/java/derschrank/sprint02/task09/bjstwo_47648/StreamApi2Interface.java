package derschrank.sprint02.task09.bjstwo_47648;

import java.util.List;
import java.util.Map;

public interface StreamApi2Interface {
    List<List<Integer>> findSum(List<Integer> numbers, int sum);

    List<String> sortCountryAndGetCapital(Map<String, String> countryAndCapital);

    List<String> findCharAndSortStrings(List<String> strings, char ch);

    List<String> makeDecToBin(List<Integer> numbers);

    List<String> filterStringsByAlphabetAndSortByLength(List<String> string, String alphabet);
}
