package faang.school.godbless.BJS24656;

public class Example {

    public static int[] reverse(int[] arr) {
        int[] arrResult = arr.clone();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return arrResult;
    }
}
