package faang.school.godbless.kxnvg.reverse;

public class Example {

    public static int[] reverse(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Массив не должен быть null");
        } else if (arr.length == 0 || arr.length == 1) {
            return arr;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int value = arr[right];
            arr[right] = arr[left];
            arr[left] = value;
            right--;
            left++;
        }

        return arr;
    }
}
