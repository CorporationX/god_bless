package trainingStreamApiSecond;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamOperations.findUniqueNumbersPairsSumWhichEqualGoal(List.of(
                1, 2, 3, 4, 5, 6), 7));
        System.out.println(StreamOperations.sortCountryByAlphabetAndGetListAllCapital(Map.of(
                "Russian", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        )));
        System.out.println(StreamOperations.filterStringByCharacterAndSortByLenght(List.of(
                "apple",
                "banana",
                "avocado",
                "apricot"
        ), 'a'));
        System.out.println(StreamOperations.convertNumberToBinary(List.of(
                1, 2, 3, 4
        )));

        System.out.println(StreamOperations.filterStringByAlphabetAndSortByLenght(List.of(
                "apple",
                "banana",
                "cherry",
                "date",
                "fig",
                "grape",
                "яблоко"
        ), "abcdefghijklmnopqrstuvwxyz"));
    }
}
