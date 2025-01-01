package practice_streamAPI_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        NumberChanger numberChanger = new NumberChanger();
        List<Integer> numbers = new ArrayList<>(List.of(2, 3, 4, 5, 2, 3, 5, 6, 6, 7, 8, 1));
        List<String> stringList = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));
        Map<String, String> countryCapitalMap = new HashMap<>() {{
            put("Россия", "Москва");
            put("США", "Вашингтон");
            put("Франция", "Париж");
            put("Япония", "Токио");
        }};
        numberChanger.findTwoNumber(numbers, 7);
        System.out.println(numberChanger.sorterCapital(countryCapitalMap));
        System.out.println(numberChanger.filterSortString(stringList, 'a'));
        System.out.println(numberChanger.converterBinary(numbers));
        System.out.println(numberChanger.filterAlphabetLength(stringList,"abcdefghijklmnopqrstuvwxyz"));
    }
}
