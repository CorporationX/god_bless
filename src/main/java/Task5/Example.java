package Task5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example {

    public void reverse(int[] list) {
//        System.out.println(Arrays.toString(list));
//        int start = 0;
//        int finish = list.length - 1;
//        while (start < finish) {
//            int x = list[start];
//            list[start] = list[finish];
//            list[finish] = x;
//            start++;
//            finish--;
//        }
        System.out.println(Arrays.toString(list));

//        System.out.println((Integer[]) (IntStream.rangeClosed(1, list.length).mapToObj(i -> list[list.length - i]).toArray()));

//        System.out.println(Arrays.stream(list).boxed().sorted((a,b) -> Integer.reverse(a,b)).flatMapToInt());
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5, 6};
        Example example = new Example();
        example.reverse(list);
    }
}
