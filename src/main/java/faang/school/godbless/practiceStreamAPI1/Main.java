package faang.school.godbless.practiceStreamAPI1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNum = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> listString = List.of("adfdfd", "afdfdf", "crrt",
                "dtyty", "etyty", "ftyty");

        StreamApiMethods streamApiMethods = new StreamApiMethods();

        System.out.println(streamApiMethods.sumEvenNumbersInList(listNum));

        System.out.println(streamApiMethods.maxNumInList(listNum));

        System.out.println(streamApiMethods.averageNumInList(listNum));

        System.out.println(streamApiMethods.countNumStartingWithSymbol("a", listString));

        System.out.println(streamApiMethods.sortedListBySubstring("fd", listString));

        System.out.println(streamApiMethods.sortedByLength(listString));

        System.out.println(streamApiMethods.CheckAllItemsInListCertainCondition(listString, (word -> word.length() == 5)));

        System.out.println(streamApiMethods.minNumInListMoreSpecifiedNum(5, listNum));

        System.out.println(streamApiMethods.ConvertListStringsToListTheirLength(listString));
    }
}
