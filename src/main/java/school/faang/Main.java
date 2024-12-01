package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listToReverse = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));

        List<Integer> reversedList = Example.reverse(listToReverse);

        System.out.println(" the result is :: " + reversedList.toString());
    }
}
