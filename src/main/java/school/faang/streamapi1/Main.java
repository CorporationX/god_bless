package school.faang.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamApiHandler.getSum(List.of(1, 2, 3, 4, 5)));
        System.out.println(StreamApiHandler.maxElem(List.of(1, 2, 3, 4, 5)));
        System.out.println(StreamApiHandler.getAvg(List.of(1, 2)));
        System.out.println(StreamApiHandler.getNumberOfStrings(List.of("abc", "atc", "brd"), 'a'));
        System.out.println(StreamApiHandler.getStringsWithSubstring(List.of("abc", "ybc", "brd"), "bc"));
    }
}
