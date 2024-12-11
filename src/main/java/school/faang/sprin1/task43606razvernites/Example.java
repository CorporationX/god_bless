package school.faang.sprin1.task43606razvernites;

import java.lang.reflect.Array;

public class Example {

    public static <T> void reverseArray(T[] inputArray) {
        if (Array.getLength(inputArray) == 0) {
            System.out.println("Массив не может быть пустым!!");
        } else if (inputArray == null) {
            System.out.println("Пустая ссылка!");
        } else {
            int leftIndex = 0;
            int rightIndex = inputArray.length - 1;
            while (leftIndex < rightIndex) {
                T temp = inputArray[leftIndex];
                inputArray[leftIndex] = inputArray[rightIndex];
                inputArray[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
    }

    public static void printArray(Object array) {
        System.out.print(array.getClass() + " ");
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(array, i);
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}

