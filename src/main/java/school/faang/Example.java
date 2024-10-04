package school.faang;

public class Example {

    public static void reverse(int[] numbers){
        if (numbers == null || numbers.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }

        for (int i = 0; i < numbers.length/2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }
    }
}
