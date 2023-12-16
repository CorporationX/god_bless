package StreamTraining_1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 6, 8, -60, 5, 55, 123 - 6);
        List<String> stringList = Arrays.asList("Rik", "Morty", "Samer", "Jerry");
        Predicate<String> predicate = (a) -> a.length() > 3;
        System.out.println(StreamTraining.sumOdd(integerList));
        System.out.println(StreamTraining.max(integerList));
        System.out.println(StreamTraining.average(integerList));
        System.out.println(StreamTraining.countString(stringList, 'J'));
        System.out.println(StreamTraining.stringFilter(stringList, "rr"));
        System.out.println(StreamTraining.stringSorter(stringList));
        System.out.println(StreamTraining.check(stringList, predicate));
        System.out.println(StreamTraining.min(integerList, 5));
        System.out.println(StreamTraining.stringForLength(stringList));
    }
}
