package faang.school.godbless;

public class Example {

    public void reverse(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int t = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = t;
            left++;
            right--;
        }
    }
}
