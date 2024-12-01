package school.faang;

import java.util.ArrayList;

public class Example {

    public static ArrayList<Integer> reverse(ArrayList<Integer> inputArray) {
        ArrayList<Integer> arrayWithReversedNumber = new ArrayList<>();

        for (int i = inputArray.size() - 1; i >= 0; i--) {
            arrayWithReversedNumber.add(inputArray.get(i));
        }

        return arrayWithReversedNumber;
    }
}
