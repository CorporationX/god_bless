package school.faang.bjs2_88144;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strList = Arrays.asList("Неаполь", "Мороженое", "юла", "лозы",
                                             "Храм", "Новосибирск", "Трикотаж", "Комуфляж");

        System.out.println(Streams.sumOfEvenNumbers(numList));
        System.out.println(Streams.maxValue(numList));
        System.out.println(Streams.avgValue(numList));
        System.out.println(Streams.strFilter(strList, 'Н'));
        System.out.println(Streams.filterList(strList, "ж"));
        System.out.println(Streams.sortStringListByLength(strList));
        System.out.println(Streams.allMatch(numList, (num) -> num > 0));
        System.out.println(Streams.minBiggerNum(numList, 4));
        System.out.println(Streams.lengthList(strList));
    }
}
