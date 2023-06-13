package faang.school.godbless;

import java.util.Arrays;

public class Example {
    public int[] reverse(int[] arr) {

        if (arr.length == 0) {
            return new int[] {};
        }

        int i = 0;
        int j = arr.length - 1;

        while (i != j) {
            System.out.println(i);
            System.out.println(j);
            int left = arr[i];
            int right = arr[j];
            arr[i] = right;
            arr[j] = left;
            i++;
            j--;
        }

        return arr;
    }
}
