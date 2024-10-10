package school.faang.streamapi1;

import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 7, 4, 8, 3, 10, 2, 6, 9);
        System.out.println(list);
        System.out.printf("Sum: %d%n", StreamApiTester.sum(list));

        System.out.printf("Max: %d%n", StreamApiTester.max(list));
        System.out.printf("Average: %f%n", StreamApiTester.average(list));
        System.out.printf("MinValueMoreThen:%d%n", StreamApiTester.minValueMoreThen(list, 8));

        List<String> stringList = List.of("black", "red", "brown", "orange", "yellow", "violet", "barn red");
        System.out.printf("\nCountStr: %d%n", StreamApiTester.countStr(stringList, 'b'));
        System.out.println("FilterBySubstring: " + StreamApiTester.filterBy(stringList, "red"));
        System.out.println("SortByLength: " + StreamApiTester.sortByLength(stringList));
        System.out.println("AllMatch: " + StreamApiTester.allMatch(stringList, str -> str.length() == 5));
        System.out.println("StringToLength: " + StreamApiTester.stringToLengths(stringList));
    }
}
