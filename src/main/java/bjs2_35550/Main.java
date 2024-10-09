package bjs2_35550;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int sumOfEvenNum = Solution.getSumOfEvenNum(List.of(1, 2, 3, 5, 6));
        int max = Solution.getMaxNum(List.of(1, 1, 54, 6));
        double averageValue = Solution.getAverageValue(List.of(1, 2, 3, 4));
        int countOFStrings = Solution.getCountOFStringsStartsWith(List.of("abc", "dfg", "aws"), 'a');
        List<String> filteredList = Solution.filterBySubstring(List.of("word", "woman", "man", "wo dude"), "wo");
        List<String> sortedList = Solution.sortStringsByLength(List.of("word", "woman", "man", "wo dude"));
        boolean isAllOverZero = Solution.isAllMatch(List.of(1, 1, 54, 6), num -> num > 0);
        int minGreaterThan = Solution.getMinGreaterThan(List.of(1, 14, 54, 6), 9);
        List<Integer> stringToLength = Solution.mapStringToLength(List.of("word", "woman", "man", "wo dude"));


        System.out.println(sumOfEvenNum);
        System.out.println(max);
        System.out.println(averageValue);
        System.out.println(countOFStrings);
        System.out.println(filteredList);
        System.out.println(sortedList);
        System.out.println(isAllOverZero);
        System.out.println(minGreaterThan);
        System.out.println(stringToLength);
    }
}
