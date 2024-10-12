package school.faang.streamtraining1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 3, 4, 9, 16, 99);
        List<Integer> integerEvenList = List.of(2, 6, 4, 18, 16, 98);
        List<String> stringList = List.of("cherry", "ice", "banana", "apple", "carrot", "panama");

        System.out.println("Sum of even numbers: " + Transform.evenNumbersSum(integerList));
        if (Transform.maxInt(List.of()).isPresent()) {
            System.out.println("Max element: " + Transform.maxInt(List.of()).get());
        } else {
            System.out.println("Value is absent");
        }

        if(Transform.average(integerList).isPresent()) {
            System.out.println("Average value: " + Transform.average(integerList));
        } else {
            System.out.println("Value is absent");
        }

        System.out.println("Count of word started with symbol: " + Transform.sameFirstCharacter(stringList, 'c'));
        System.out.println("Words contains substring: " + Transform.containsSubstring(stringList, "ana"));
        System.out.println("Sorted list: " + Transform.sortStringList(stringList));
        System.out.println("All match: " + Transform.checkAllMatch(integerEvenList, num -> num % 2 == 0));

        if(Transform.findMinBiggerThen(integerList, 4).isPresent()) {
            System.out.println("Min value bigger then " + Transform.findMinBiggerThen(integerList, 4));
        } else {
            System.out.println("Value is absent");
        }

        System.out.println("Word's length " + Transform.stringToInteger(stringList));
    }
}
