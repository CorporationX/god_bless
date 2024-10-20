package school.faang;

import school.faang.methods.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Method method = new Method();

        List<Integer> numbers= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        int point = 7;
        System.out.println("Вход: " + numbers + " целевое число: " + point);
        System.out.println("Выход: " + method.searchPairs(numbers, point));

        Map<String, String> coutry = new HashMap<>(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany","Berlin")
        );

        System.out.println("Вход: " + coutry);
        System.out.println("Выход: " + method.sortCapitals(coutry));


        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "avocado", "apricot"));
        char ch = 'a';
        System.out.println("Вход: " + words + " символ: " + ch);
        System.out.println("Выход: " + method.filterAndSort(words, ch));


        System.out.println("Вход: " + numbers );
        System.out.println("Выход: " + method.convertBinary(numbers));

        List<String> words2 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape"));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Вход: " + words2 + " aлфавит: " + alphabet);
        System.out.println("Выход: " + method.sortByLength(words2, alphabet));
    }
}
