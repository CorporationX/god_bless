package school.faang;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listToReverse = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        ArrayList<Integer> reversedList = Example.reverse(listToReverse);

        System.out.println(" the result is :: " + reversedList.toString());
    }
}
