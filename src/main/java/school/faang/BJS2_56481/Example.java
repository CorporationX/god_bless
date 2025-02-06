package school.faang.BJS2_56481;

public class Example {
    public static int[] reverse(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }
}