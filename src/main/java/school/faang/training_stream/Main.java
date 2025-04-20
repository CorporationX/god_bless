package school.faang.training_stream;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 5, 6, 2, 8, 10, 4, 7);
        Predicate<Integer> filter;
        System.out.println(Training.sumList(integerList));
        System.out.println(Training.maxValue(integerList));
        System.out.println(Training.averageValue(integerList));
        System.out.println(Training.allMatch(integerList, a -> a > 11));
        System.out.println(Training.floorNumber(integerList, 3));

        List<String> stringList = List.of("bob clone", "wod list", "beb map", "lom son", "word lom", "bor bum");
        System.out.println(Training.countStringsStartingWith(stringList, 'b'));
        System.out.println(Training.findWithSubstring(stringList, "lom"));
        System.out.println(Training.sortedByLength(stringList));
        System.out.println(Training.converterToLength(stringList));

    }
}
