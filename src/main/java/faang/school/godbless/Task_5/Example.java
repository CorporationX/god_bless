package faang.school.godbless.Task_5;

public class Example {
    int[] reverse(int[] array) {

        int temp;
        int[] newArray = new int[array.length];
        int j = 0;

        for (int i = 0; i < array.length - 1; i++) {

            temp = array[j++];
            newArray[array.length - j] = temp;

        }
        return newArray;
    }
}
