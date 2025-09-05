package school.faang.reverse;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        Example.reverse(numbers);

        System.out.print("Result: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}