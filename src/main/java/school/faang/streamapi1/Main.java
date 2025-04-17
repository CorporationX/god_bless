package school.faang.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamApiOperations.getSum(List.of(1, 2, 3, 4, 5)));
        System.out.println(StreamApiOperations.maxElement(List.of(1, 2, 3, 4, 5)));
        System.out.println(StreamApiOperations.getAvg(List.of(1, 2)));
        System.out.println(StreamApiOperations.getNumberOfStrings(List.of("abc", "atc", "brd"), 'a'));
        System.out.println(StreamApiOperations.getStringsWithSubstring(List.of("abc", "ybc", "brd"), "bc"));
    }
}
