package faang.school.godbless.BJS2_18846;

public class Example {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        reverse(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void reverse(int[] numbers) {

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

    }
}
