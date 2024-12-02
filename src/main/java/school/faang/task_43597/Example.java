package school.faang.task_43597;

public class Example {

    public static void reverse(int[] inputArray) {

        int increasingIndex = 0;
        int decreasingIndex = inputArray.length - 1;

        while (increasingIndex < decreasingIndex) {
            int tempValue = inputArray[increasingIndex];
            inputArray[increasingIndex] = inputArray[decreasingIndex];
            inputArray[decreasingIndex] = tempValue;
            increasingIndex++;
            decreasingIndex--;
        }
    }
}
