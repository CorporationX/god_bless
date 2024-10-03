package school.faang.turnaround;

public class Example {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        turnAround(array);
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void turnAround(int[] array) {
        int halfArrayLength = array.length / 2;
        int index = 0;
        int tempNum;
        for (int i = 0; i < halfArrayLength; i++) {
            tempNum = array[index];
            array[index] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tempNum;
            index++;
        }
    }
}
