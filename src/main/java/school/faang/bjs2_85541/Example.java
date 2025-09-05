package school.faang.bjs2_85541;

public class Example {
    public static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int reversingNumber = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = reversingNumber;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("before reversing");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        reverse(numbers);
        System.out.println("after reversing");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
