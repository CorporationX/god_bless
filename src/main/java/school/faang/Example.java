package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static List<Integer> reverse(List<Integer> inputArray) {
        List<Integer> arrayWithReversedNumber = new ArrayList<>();

        for (int i = inputArray.size() - 1; i >= 0; i--) {
            arrayWithReversedNumber.add(inputArray.get(i));
        }

        return arrayWithReversedNumber;
    }
}
