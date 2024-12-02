package school.faang.task_43627;

public class Example {

    public static int[] reverse(int[] normalArray) {
        int[] reversedArray = new int[normalArray.length];

        for (int normalArrayIndex = 0,
             reversedArrayIndex = normalArray.length - 1;
             normalArrayIndex < normalArray.length;
             normalArrayIndex++, reversedArrayIndex--) {
            reversedArray[reversedArrayIndex] = normalArray[normalArrayIndex];

        }
        return reversedArray;
    }
}
