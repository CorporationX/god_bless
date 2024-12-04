package school.faang.sprin1.task_43606_razvernites;

import java.lang.reflect.Array;

public class Example {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        String[] strings = {"a", "b", "c", "d"};
        reverse(nums);
        reverse(strings);
        printArray(nums);
        printArray(strings);
    }

    public static <T> void reverse(T[] dataArray) {
        int left = 0;
        int right = dataArray.length - 1;
        while (left < right) {
            T temp = dataArray[left];
            dataArray[left] = dataArray[right];
            dataArray[right] = temp;
            left++;
            right--;
        }
    }

    public static void printArray(Object array) {

        try {
            System.out.print(array.getClass() + " ");
            int lenght = Array.getLength(array);
            for (int i = 0; i < lenght; i++) {
                Object element = Array.get(array, i);
                System.out.print(element + ", ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
        }
    }
}

