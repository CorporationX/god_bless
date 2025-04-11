package school.faang.arrayrevert;

import lombok.Data;

@Data
public class Example {
    public static void reverse(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length / 2; i++) {
            temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }
}
