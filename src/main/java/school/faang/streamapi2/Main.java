package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> mapCountrysAbdCapital = new HashMap<>();
        mapCountrysAbdCapital.put("Russia", "Moscow");
        mapCountrysAbdCapital.put("USA", "Washington");
        mapCountrysAbdCapital.put("Germany", "Berlin");

        List<Integer> listForTaskOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> listForTaskThree = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> listForTaskFive = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        List<Integer> listForTaskFour = Arrays.asList(1, 2, 3, 4);

        //1
        System.out.println(ListOperations.findUniqPairNumbers(listForTaskOne, 7));

        //2
        System.out.println(ListOperations.mapCountryWithCapitals(mapCountrysAbdCapital));

        //3
        System.out.println(ListOperations.filerAndSort(listForTaskThree, 'a'));

        //4
        System.out.println(ListOperations.numbersToBinaryString(listForTaskFour));

        //5
        System.out.println(ListOperations.filerForAlphabet(listForTaskFive, "abcdefghijklmnopqrstuvwxyz"));
    }
}
