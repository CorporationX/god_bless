package faang.school.godbless.StreamAPI.Stream_API1;

import java.util.List;

public class Main {
    private static List<Integer> numers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 23, 65, 45);
    private static List<String> fruits = List.of("apple", "banana", "avocado", "cherry", "apricot", "date");
    private static List<String> fruitsA = List.of("apple", "avocado", "apricot");

    public static void main(String[] args) {
        System.out.println(Solution.outputSumEvenNumbers(numers));
        System.out.println(Solution.outputMaxNumber(numers));
        System.out.println(Solution.outputAverageNumber(numers));

        char prefix = 'a';
        System.out.println(Solution.countLineStartingWith(fruits, prefix));

        System.out.println(Solution.filterStringWithValue(fruits, "apple"));
        System.out.println(Solution.sortLineLength(fruits));

        char prefix2 = 'a';
        System.out.println(Solution.checkingAllElementsForCondition(fruitsA, prefix2));
        System.out.println(Solution.findSmallNumberMoreN(numers, 10));
        System.out.println(Solution.stringToListLength(fruits));
    }
}
