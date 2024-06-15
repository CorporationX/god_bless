package faang.school.godbless.task26;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

    }
    public static int sumElements(List<Integer> list) {
       return list.stream().filter(x->x%2==0).mapToInt(a->a).sum();
    }
    public static int maxElements(List<Integer> list) {
        return list.stream().max(Integer::compare).orElseThrow(()-> new NoSuchElementException("No max element found"));
    }
    public static double avgElement(List<Integer> list) {
        return list.stream().filter(x->x%2==0).mapToInt(a->a).average().orElseThrow(()-> new NoSuchElementException("No avg element found"));
    }
    public static List<String> stringStartWithPrefix(List<String> list, String pefix) {
        return list.stream().filter(x->x.startsWith(pefix)).toList();
    }
    public static List<String> filterStringsBySubstring(List<String> list, String substring) {
        return list.stream().filter(x->x.contains(substring)).toList();
    }
    public static List<String> filterStringsBySize(List<String> list) {
        return list.stream().sorted((x,y)->y.length()-x.length()).toList();
    }
    public static boolean allElementsSatisfyCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }
    public static int findSmallestElementGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream().filter(n -> n > number).min(Integer::compareTo).orElseThrow(()-> new NoSuchElementException("No min element found"));
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
