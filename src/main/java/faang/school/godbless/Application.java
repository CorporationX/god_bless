package faang.school.godbless;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class Application {
    public static void main(String... args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> stringList = List.of("Adam", "Me", "My");
        System.out.println(UtilStream.findSumsEvenNumbers(numbers));
        System.out.println(UtilStream.findMaxNumber(numbers));
        System.out.println(UtilStream.findAverageNumber(numbers));
        System.out.println(UtilStream.findNumberLinesStartingWithSpecChar(stringList, 'm'));

    }
}
