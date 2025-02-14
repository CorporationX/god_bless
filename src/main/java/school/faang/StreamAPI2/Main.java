package school.faang.StreamAPI2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(3, 4, 5, 6, 7, 8, 9);
        //Найдите уникальные пары чисел
        System.out.println(ListOperations2.findPairs(set, 13));
        //Отсортируйте страны и выведите столицы

        Map<String, String> capitalAndCountry = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");


    }
}
