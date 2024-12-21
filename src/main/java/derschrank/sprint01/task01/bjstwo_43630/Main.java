package derschrank.sprint01.task01.bjstwo_43630;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        reverseArrayOfSimpleInts();
        reverseArrayOfObjects();
    }

    private static void reverseArrayOfSimpleInts() {
        int[] arrayOfInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(arrayOfInt));
        System.out.println(Arrays.toString(Example.reverse(arrayOfInt)));
    }

    private static void reverseArrayOfObjects() {
        final List<Object[]> listOfArrays = getListOfArraysOfObjects();

        for (Object[] obj : listOfArrays) {
            System.out.println("-----------------------------");
            System.out.println(Arrays.toString(obj));
            System.out.println(Arrays.toString(ReverseArray.doReverse(obj)));
        }
        System.out.println("-----------------------------");
    }

    private static List<Object[]> getListOfArraysOfObjects() {
        final List<Object[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        listOfArrays.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        listOfArrays.add(new String[] {"one", "two", "three"});
        listOfArrays.add(new LocalDateTime[]{
                LocalDateTime.now(),
                LocalDateTime.of(2024, Month.DECEMBER, 4, 2, 33),
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2)
        });
        return listOfArrays;
    }
}
