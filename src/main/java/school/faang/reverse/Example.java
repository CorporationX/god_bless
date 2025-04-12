package school.faang.reverse;

public class Example {

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
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


