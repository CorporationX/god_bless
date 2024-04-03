package faang.school.godbless.reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example {

    public List<Integer> reverse(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
        return ans;
    }

}
