package faang.school.godbless.BJS2_18846;

public class Example {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        reverse(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void reverse(int[] numbers) {

        if(numbers.length == 0 || numbers == null) {
            throw new IllegalArgumentException("Provided array is null or empty");
        }

        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

    }
}
