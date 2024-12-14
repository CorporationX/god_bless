package faang.school.godbless.reverse;

public class Example {

    public static int[] reverse(int[] array) {
        int[] reverseArray = array;
        int lengthArray = reverseArray.length - 1;
        for(int i = 0; i < reverseArray.length/2; i++) {
            int temp = reverseArray[i];
            reverseArray[i] = reverseArray[lengthArray - i];
            reverseArray[lengthArray -  i] = temp;
        }
        return reverseArray;
    }
}
