package faang.school.godbless.practiceStreamAPI1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamApiMethods {
    public int sumEvenNumbersInList(List<Integer> nums) {
        return nums.stream()
                .mapToInt(num -> num)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public int maxNumInList(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compare)
                .get();
    }

    public double averageNumInList(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(num -> num)
                .average()
                .getAsDouble();
    }

    public int countNumStartingWithSymbol(String symbol, List<String> words) {
        return (int) words.stream()
                .filter(word -> word.startsWith(symbol))
                .count();
    }

    public List<String> sortedListBySubstring(String substring, List<String> words) {
        List<String> sortedWords = new ArrayList<>();

        words.stream()
                .filter(word -> word.contains(substring))
                .forEach(sortedWords::add);

        return sortedWords;
    }

    public List<String> sortedByLength(List<String> words) {
        List<String> sortedWords = new ArrayList<>(words);

        Collections.sort(sortedWords, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return word1.length() - word2.length();
            }
        });
        return sortedWords;
    }

    public boolean CheckAllItemsInListCertainCondition(List<String> words,
                                                       Predicate<String> condition) {
        return words.stream().allMatch(condition::test);
    }

    public int minNumInListMoreSpecifiedNum(int specifiedNum, List<Integer> nums) {
        return nums.stream()
                .filter(num -> num > specifiedNum)
                .min(Integer::compare)
                .get();
    }

    public List<Integer> ConvertListStringsToListTheirLength(List<String> words) {
        List<Integer> list = new ArrayList<>();

        words.stream().mapToInt(String::length).forEach(list::add);

        return list;
    }
}
