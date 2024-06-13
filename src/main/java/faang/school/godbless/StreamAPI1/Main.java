package faang.school.godbless.StreamAPI1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, StreamAPITestDrive> houses = new HashMap<>();

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> strings = List.of("abc", "de", "agr");

        System.out.println(StreamAPITestDrive.sumOfEvenNumbers(numbers));
        System.out.println(StreamAPITestDrive.maxElement(numbers));
        System.out.println(StreamAPITestDrive.averageValue(numbers));
        System.out.println(StreamAPITestDrive.numberOfStringsStartsWith(strings, 's'));
        System.out.println(StreamAPITestDrive.stringsContains(strings, "a"));
        System.out.println(StreamAPITestDrive.sortByLength(strings));
        System.out.println(StreamAPITestDrive.allMatch(strings, str -> str.length() > 1));
        System.out.println(StreamAPITestDrive.minimumThatBiggerThan(numbers, 4));
        System.out.println(StreamAPITestDrive.stringsToTheirLength(strings));
    }
}
