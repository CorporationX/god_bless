package faang.school.godbless.StreamAPI1;

import java.util.List;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        List<Integer> nums = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = List.of("Moscow", "SPB", "Novosibirsk", "Tomsk", "Rubtsovsk");

        System.out.println(Analyzer.sumOfEvenNumbers(nums));

        System.out.println(Analyzer.max(nums));

        System.out.println(Analyzer.avg(nums));

        System.out.println(Analyzer.startsWith(strings, 'R'));

        System.out.println(Analyzer.contents(strings, "sk"));

        System.out.println(Analyzer.SortByLength(strings));

        Predicate<String> predicate1 = (s) -> s.length() > 6;
        Predicate<String> predicate2 = (s) -> s.length() > 2;
        System.out.println(Analyzer.checkCondition(strings,predicate1));
        System.out.println(Analyzer.checkCondition(strings,predicate2));

        System.out.println(Analyzer.minBiggerThen(nums, 6));

        System.out.println(Analyzer.stringsLength(strings));
    }
}
