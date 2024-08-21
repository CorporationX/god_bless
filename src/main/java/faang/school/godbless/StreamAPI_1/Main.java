package faang.school.godbless.StreamAPI_1;

import java.util.Arrays;
import java.util.List;

import static faang.school.godbless.StreamAPI_1.ClassStatic.checkingElementsByTrue;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getAverageElement;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getCountStringsContains;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getCountStringsStatsWith;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getFilterStringsByLength;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getMaxElement;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getMinElementGreaterThanAGivenNumber;
import static faang.school.godbless.StreamAPI_1.ClassStatic.getSumEven;
import static faang.school.godbless.StreamAPI_1.ClassStatic.mapStringToListLength;

public class Main {
    public static void main(String[] args) {
        System.out.println(getSumEven(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getMaxElement(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getAverageElement(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getCountStringsStatsWith(List.of("abc", "abd", "dbf"), "ab"));
        System.out.println(getCountStringsContains(List.of("abc", "abd", "dbf"), "f"));
        System.out.println(getFilterStringsByLength(List.of("abababa", "asfas", "11", "asf")));
        System.out.println(checkingElementsByTrue(List.of(2.5, 3.4, 5.4, 4.0), a -> a > 5));
        System.out.println(getMinElementGreaterThanAGivenNumber(List.of(1, 2, 3, 4, 5, 6), 3));
        System.out.println(mapStringToListLength(List.of("abababa", "asfas", "11", "asf")));
    }
}
