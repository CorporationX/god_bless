package school.faang.bjs2_79222;

public class Example {

    public int[] reverse(int[] numbers) {
        for (int index = 0; index < numbers.length / 2; index++) {
            int temp = numbers[index];
            numbers[index] = numbers[numbers.length - index - 1];
            numbers[numbers.length - index - 1] = temp;
        }

        return numbers;
    }
}
