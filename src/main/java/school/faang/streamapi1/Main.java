package school.faang.streamapi1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        System.out.println(StreamApiOperations.getSum(List.of(1, 2, 3, 4, 5)));
        System.out.println(StreamApiOperations.maxElement(List.of(1, 2, 3, 4, 5)));
        System.out.println(StreamApiOperations.getAvg(List.of(1, 2)));
        System.out.println(StreamApiOperations.getNumberOfStrings(List.of("abc", "atc", "brd"), 'a'));
        System.out.println(StreamApiOperations.getStringsWithSubstring(List.of("abc", "ybc", "brd"), "bc"));
        System.out.println(StreamApiOperations.getSortedByLength(List.of("aaaa", "aaa", "aa")));
        System.out.println(StreamApiOperations.checkIfAllMatch(List.of(1, 2, 3, 4, 5), number -> number > 0));
        System.out.println(StreamApiOperations.getHigherNumber(List.of(10, 5, 20, 15, 3, 7), 6));
        System.out.println(StreamApiOperations.getStringsLength(List.of("aaaa", "aaa", "aa")));
    }
}
