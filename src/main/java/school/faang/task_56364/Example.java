package school.faang.task_56364;

public class Example {
    public static void main(String[] args) {
        int[] array = {1, 5, 10, 20, 50};
        System.out.println("Array before reverse:");
        printArray(array);

        int[] reverseArray = reverseArray(array);
        System.out.println("Array after reverse:");
        printArray(reverseArray);
    }

    static int[] reverseArray(int[] array) {
        int length = array.length; // 5
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
        return array;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%d] ", array[i]);
        }
        System.out.println();
    }
}
