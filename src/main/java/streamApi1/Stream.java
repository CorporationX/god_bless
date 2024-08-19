package streamApi1;

import java.util.*;

public class Stream {

    public static int count(List<Integer> integerList) {
        int count = integerList.stream().limit(4).reduce(0, (sum, integer) -> sum + integer);
        return count;
    }

    public static Optional<Integer> maxInt(List<Integer> integerList) {
        Optional<Integer> maxInt = integerList.stream().max(Comparator.comparingInt(num -> num));
        if (maxInt.isPresent()) {
            return maxInt;
        } else {
            Optional<Integer> maxIntNull = Optional.of(0);
            return maxIntNull;
        }
    }

    public static int srInt(List<Integer> integerList) {
        int listSize = integerList.size();
        int srInt = integerList.stream().reduce(0, (sum, integer) -> (sum + integer)) / listSize;
        return srInt;
    }

    public static Optional<Integer> countString(List<String> stringList) {
        Optional<Integer> countString = Optional.of((int) stringList.stream().filter(word -> word.startsWith("С")).count());
        if (countString.isPresent()) {
            return countString;
        } else {
            Optional<Integer> countStringNull = Optional.of(0);
            return countStringNull;
        }
    }

    public static List<String> sortString(List<String> stringList, String substring) {
        List<String> sortedSubstring = stringList.stream().filter(word -> word.contains(substring)).toList();
        return sortedSubstring;
    }

    public static List<String> filterLength(List<String> stringList) {
        List<String> filterLength = stringList.stream().sorted(Comparator.comparingInt(String::length)).toList();
        return filterLength;
    }

    public static boolean checkList(List<String> stringList) {
        boolean checkList = stringList.stream().allMatch(word -> word.length() > 5);
        return checkList;
    }

    public static Optional<Integer> matchNum(List<Integer> integerList, int lowerBorder) {
        Optional<Integer> num = integerList.stream().filter(number -> number > lowerBorder).min(Comparator.comparingInt(number -> number));
        if (num.isPresent()) {
            return num;
        } else {
            Optional<Integer> numNull = Optional.of(0);
            return numNull;
        }
    }

    public static List<Integer> stringToLength(List<String> stringList) {
        List<Integer> integerList = stringList.stream().map(word -> word.length()).toList();
        return integerList;
    }
}
