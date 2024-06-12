package turn;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        List list = new ArrayList<>(Arrays.asList(array));
        reverse(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void reverse(List list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Integer value = (Integer) list.remove(0);
        reverse(list);
        list.add(value);
    }
}
