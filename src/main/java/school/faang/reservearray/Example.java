package school.faang.reservearray;

import java.util.ArrayList;
import java.util.Collections;

public class Example {
    public ArrayList<Integer> reserve(int[] array) {
        ArrayList<Integer> listArray = new ArrayList<>();

        for(int element : array) {
            listArray.add(element);
        }

        Collections.reverse(listArray);
        return listArray;
    }
}
