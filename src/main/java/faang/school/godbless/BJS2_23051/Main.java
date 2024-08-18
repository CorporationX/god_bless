package faang.school.godbless.BJS2_23051;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
        System.out.println(Streams.sumEvenNumbers(intList));
        System.out.println(Streams.maxNumList(intList));
        System.out.println(Streams.avgNumList(intList));
        System.out.println(Streams.minElementList(intList, 2));

        boolean isEven = Streams.areAllElementsSatisfyingCondition(intList, n -> (n % 2) == 0); // работает только если указать тип в Predicate, не понимаю в чем проблема
        System.out.println(isEven);

        List<String> strings = Arrays.asList("Hehe", "Hello", "Nice", "hs", "H");
        System.out.println(Streams.stringCertainCharacterCount(strings, "-"));
        System.out.println(Streams.convertListOfLength(strings));
//
        System.out.println(Streams.stringsSpecificSubstring(strings, "He"));
        System.out.println(Streams.listStringsLength(strings, 3));

    }
}
