package school.faang.BJS2_85442;

public class Example {
    static void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int number = arr[left];
            arr[left] = arr[right];
            arr[right] = number;
            left++;
            right--;
        }
    }
}
