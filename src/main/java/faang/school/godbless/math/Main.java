package faang.school.godbless.math;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> list = Arrays.asList("Hello", "World", "Book1", "Book2", "Book3", "a", "aa");
        Predicate<String> condition = word -> word.length() < 10;

        System.out.println(Math.sumOfEven(numbers));
        System.out.println(Math.max(numbers));
        System.out.println(Math.average(numbers));

        System.out.println(Math.countStringStartingWith(list, 'B'));
        System.out.println(Math.filterStringsContainsSubstring(list, "Book"));
        System.out.println(Math.sortStringsByLength(list));


        System.out.println(Math.allElementsMatchCondition(list, condition ));

        System.out.println(Math.findSmallestThan(numbers, 3));
        System.out.println(Math.converterToLength(list));
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static void handlerOptional(Optional<?> result, String message){
        if (result.isPresent()) {
            System.out.println("Result: " + result.get());
        } else {
            System.out.println(message);
        }
    }
}
