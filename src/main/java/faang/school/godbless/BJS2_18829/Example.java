package faang.school.godbless.BJS2_18829;

public class Example {
    static int[] reverse(int[] numbers) {
        int indexEnd = numbers.length - 1;
        int indexCenter = numbers.length / 2;
        for (int indexStart = 0; indexStart < numbers.length; indexStart++) {
            if (indexEnd >= indexCenter) {
                int temp = numbers[indexStart];
                numbers[indexStart] = numbers[indexEnd];
                numbers[indexEnd] = temp;
                indexEnd--;
            }
        }
        return numbers;
    }
}
