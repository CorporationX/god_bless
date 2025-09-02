package school.faang.BJS2_85524;

import java.util.Arrays;

public class Example {
    static int[] revers(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] example = {1, 2, 3, 4, 5, 5, -1};
        Example.revers(example);
        assert Arrays.equals(example, new int[]{-1, 5, 5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(Example.revers(example)));
    }
}
