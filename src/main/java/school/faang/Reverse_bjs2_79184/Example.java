package school.faang.Reverse_bjs2_79184;

public class Example {
    public static void reverse(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        } else {
            for (int i = 0; i < arr.length / 2; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = tmp;
            }
        }
    }
    public static void printArr(int[] arr) {
        System.out.println("Массив:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
