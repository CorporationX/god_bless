package faang.school.godbless;

public class Example {

    public static int[] reverse(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
