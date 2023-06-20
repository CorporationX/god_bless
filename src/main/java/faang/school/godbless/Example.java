package faang.school.godbless;

public class Example {
    public int[] reverse(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                left++;
                right--;
            }

        return numbers;
    }
}
