package school.faang.streamone;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> listNumbers = List.of(1, 4, 6, 10, 23, 64, 23, 100);
        List<String> stringList = List.of("apple",
                "banana",
                "havana");

        System.out.println(StreamApiOne.sumEvenNumbers(listNumbers));
        System.out.println(StreamApiOne.maxNumber(listNumbers));
        System.out.println(StreamApiOne.avgNumbers(listNumbers));
        System.out.println(StreamApiOne.countLines(stringList, 'a'));
        System.out.println(StreamApiOne.searchLines(stringList, "havana"));
        System.out.println(StreamApiOne.sortedByLength(stringList));
        System.out.println(StreamApiOne.isBoolean(stringList, 'a'));
        System.out.println(StreamApiOne.minNumber(listNumbers, 10));
        System.out.println(StreamApiOne.lengthLines(stringList));

    }
}