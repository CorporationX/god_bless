package school.faang;

public class Example {
    public static int[] reverse(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.print("Error! The input array is null or empty! ");
            return numbers;
        }

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int temp = numbers[leftIndex];
            numbers[leftIndex] = numbers[rightIndex];
            numbers[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return numbers;
    }
}
