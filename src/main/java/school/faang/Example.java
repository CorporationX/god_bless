package school.faang;

public class Example {
    public static Integer[] reverse(Integer[] arr) {
        int tmp;
        for (int i = 0; i < arr.length / 2; i++) {
            tmp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
