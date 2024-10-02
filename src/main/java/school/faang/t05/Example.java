package school.faang.t05;

import java.util.List;

public class Example {
    public static <Integer> void reverse(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Integer temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }
}
