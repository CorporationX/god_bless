package Task5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example {

    public int[] reverse(int[] list) {

        int start = 0;
        int finish = list.length - 1;
        while (start < finish) {
            int x = list[start];
            list[start] = list[finish];
            list[finish] = x;
            start++;
            finish--;
        }
        return list;
    }
}
