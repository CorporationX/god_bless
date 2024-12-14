package faang.school.godbless.BJS2_7678;

public class Example {

    public void reverse(int[] array) {
        int[] numbers = {1, 2, 3, 4, 5, 6,};

        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}

