package faang.school.godbless.task2;


public class Example {

    public static void reverse(int[] arr) {
        int tail = arr.length - 1;
        for (int k = 0; k < arr.length/2; k++) {
            int temp = arr[k];
            arr[k]=arr[tail - k];
            arr[tail - k] = temp;
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 1, 4, 5};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }

        Example example = new Example();
        example.reverse(arr1);
    }
}