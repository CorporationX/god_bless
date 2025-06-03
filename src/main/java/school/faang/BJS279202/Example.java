package school.faang.BJS279202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example {
    public List<Integer> reverse(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (int list1 : list) {
            result.add(list1);
        }

        Collections.reverse(result);
        return result;
    }
}
