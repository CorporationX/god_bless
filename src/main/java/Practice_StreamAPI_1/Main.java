package Practice_StreamAPI_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 45, 3, 2, 0, 87);
        List<String> strings = Arrays.asList("sun", "star", "universe", "cosmos", "planet");

        System.out.println(PracticeStreamAPI.checkAllElements(numbers, number -> number >= 1));
        System.out.println(PracticeStreamAPI.findAverageValue(numbers));
        System.out.println(PracticeStreamAPI.findMaxElement(numbers));
        System.out.println(PracticeStreamAPI.findMinMoreThenNumber(numbers,3));
        System.out.println(PracticeStreamAPI.findSumOfEvenNumbers(numbers));
        System.out.println(PracticeStreamAPI.findQuantityOfStringsStartsWithSymbol(strings,"s"));
        System.out.println(PracticeStreamAPI.leaveThatContainSubstring(strings,"un"));
        System.out.println(PracticeStreamAPI.sortByLength(strings));
        System.out.println(PracticeStreamAPI.toLengthList(strings));
    }
}
