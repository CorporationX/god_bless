package school.faang.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 25, 6, 7, 8, 9, 10, 12);
        System.out.println(StaticMethods.sumEvenNumbers(integers));
        System.out.println(StaticMethods.maxValue(integers));
        System.out.println(StaticMethods.averageValue(integers));

        List<String> stringList = List.of("Apple", "Orange", "Banana", "Apricot", "Airplane", "Amigo", "Ape");
        System.out.println(StaticMethods.stringsNumber(stringList, 'A'));
        System.out.println(StaticMethods.substringFinder(stringList, "Ap"));
        System.out.println(StaticMethods.stringsSorter(stringList));
        System.out.println(StaticMethods.predicateChecker(integers, n -> n > 2));
        System.out.println(StaticMethods.minValue(integers, 10));
        System.out.println(StaticMethods.toStringLength(stringList));
    }
}
