package faang.school.godbless.r_edzie.basic.reverse;

public class Example {
    public static int[] reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left != right) {
            int temp = arr[left];

            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return arr;
    }
}
