package school.faang.task_47444;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumTwoNumber = 7;
        System.out.println("Список пар сумма которых равна " + sumTwoNumber + " :"
                + ListOperations.foundPairsOfSum(numbers, sumTwoNumber));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        System.out.println("Отсортированный список столиц " + ListOperations.sortedCaps(countries));


        List<String> fruits = new ArrayList<>();
        fruits.add("appleffff");
        fruits.add("banana");
        fruits.add("avocado");
        fruits.add("apricot");
        String symble = "a";

        System.out.println("Отсортированный список фруктов " + ListOperations.sortedCharAndLenght(fruits, symble));

        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);

        System.out.println("Список чисел в двоичном ввиде " + ListOperations.numberToBinaryNumber(numbersList));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Осортированный список с проверкой наличия букв : "
                + ListOperations.checkWordInAlphabet(words, alphabet));
    }


}
