package faang.school.godbless.task_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example {
    public static void reverse(Integer[] arr){
        List<Integer> list = new ArrayList<>(List.of(arr));
        Collections.reverse(list);
        list.toArray(arr);
    }
}
