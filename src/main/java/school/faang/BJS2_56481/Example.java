package school.faang.BJS2_56481;

public class Example {
    public static int[] reverse(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        if (arr == null) {
            return arr;
        } else if (arr.length <= 1) {
            return arr;
        } else {

            while (leftIndex < rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
            return arr;
        }
    }
}