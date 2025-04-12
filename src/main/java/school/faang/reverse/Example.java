package school.faang.reverse;

public class Example {

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }

        int length = numbers.length;
        int[] reversedArray = new int[length];
        for (int number : numbers) {
            reversedArray[--length] = number;
        }
        return reversedArray;
    }

}


