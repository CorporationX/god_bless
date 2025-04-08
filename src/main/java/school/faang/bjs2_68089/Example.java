package school.faang.bjs2_68089;

import java.util.ArrayList;

public class Example {

    public void reverseArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public void reverseUsingList (int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }
        list.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }
}