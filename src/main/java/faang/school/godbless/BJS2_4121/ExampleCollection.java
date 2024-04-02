package faang.school.godbless.BJS2_4121;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ExampleCollection {
    static List<Integer> reverse(List<Integer> array) {
        List<Integer> reversedArray = new ArrayList<>(array);
        Collections.reverse(reversedArray);
        return reversedArray;
    }
}
