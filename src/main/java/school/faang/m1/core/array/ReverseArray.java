package school.faang.m1.core.array;

import java.util.Arrays;

public class ReverseArray {
    static int[] revers(int[] arr) {
        if (arr == null) {
            return new int[]{};
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] example = {1, 2, 3, 4, 5, 5, -1};
        System.out.println(Arrays.toString(ReverseArray.revers(example)));
        assert Arrays.equals(example, new int[]{-1, 5, 5, 4, 3, 2, 1});
        example = new int[]{};
        System.out.println(Arrays.toString(ReverseArray.revers(example)));
        assert Arrays.equals(example, new int[]{});
        example = new int[]{1};
        System.out.println(Arrays.toString(ReverseArray.revers(example)));
        assert Arrays.equals(example, new int[]{1});
    }
}
