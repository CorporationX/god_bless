package faang.school.godbless.reverse;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }
}
