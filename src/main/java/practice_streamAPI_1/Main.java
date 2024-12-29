package practice_streamAPI_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final NumberChanger numberChanger = new NumberChanger();

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>(List.of("Char", "Char", "Wow", "", " "));
        stringList.add(null);
        integerList.add(2);
        integerList.add(2);
        integerList.add(6);
        integerList.add(10);
        integerList.add(15);

        System.out.println(numberChanger.addingListNumbers(integerList));
        System.out.println(numberChanger.searchMaxNumber(integerList));
        System.out.println(numberChanger.calculatingAverageNumber(integerList));
        System.out.println(numberChanger.countInitialChar('c', stringList));
        System.out.println(numberChanger.filtersList(stringList,"wo"));
        System.out.println(numberChanger.sortLengthStrings(stringList));
        System.out.println(numberChanger.checkListIntegerCondition(integerList, integer -> integer % 2 == 0));
        System.out.println(numberChanger.findMinGreaterThan(integerList,14));
        System.out.println(numberChanger.convertToLengths(stringList));
    }
}
