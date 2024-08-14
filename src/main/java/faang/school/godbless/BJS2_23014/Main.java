package faang.school.godbless.BJS2_23014;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,4,6,8,11,22,44);
        List<String> strings = Arrays.asList("one", "asdas", "erowwqe", "azcczx", "asdwqrwer");
        System.out.println(Exercises.getEvenSum(numbers));
        System.out.println(Exercises.findMaxNumb(numbers));
        System.out.println(Exercises.findAverageNumber(numbers));
        System.out.println(Exercises.findWordsStartingWithSpecificChar(strings, "a"));
        System.out.println(Exercises.findBySpecificString(strings, "asd"));
        System.out.println(Exercises.sortStrings(strings));
        System.out.println(Exercises.checkIfAllHaveSameSize(strings, 3));
        System.out.println(Exercises.findLowestNumb(numbers, 14));
        System.out.println(Exercises.convertStringsToLength(strings));
    }
}
