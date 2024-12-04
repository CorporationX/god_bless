package derschrank2000.task01_BJS2_43630;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static List<Object[]> listOfArrays = new ArrayList<>();

    static {
        listOfArrays.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        listOfArrays.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        listOfArrays.add(new String[] {"one", "two", "three"});
        listOfArrays.add(new LocalDateTime[]{
                LocalDateTime.now()
                , LocalDateTime.of(2024, Month.DECEMBER, 4, 2, 33)
                , LocalDateTime.now().plusDays(1)
                , LocalDateTime.now().plusDays(2)
        });
    }
    public static void main(String[] args) {
        //Simple
        int[] arrayOfInt = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        System.out.println(Arrays.toString(arrayOfInt));
        System.out.println(Arrays.toString(Example.reverse(arrayOfInt)));

        //Extend
        for(Object[] obj : listOfArrays){
            System.out.println("-----------------------------");
            System.out.println(Arrays.toString(obj));
            System.out.println(Arrays.toString(reverseArray.doReverse(obj)));
        }
        System.out.println("-----------------------------");

    }
}
