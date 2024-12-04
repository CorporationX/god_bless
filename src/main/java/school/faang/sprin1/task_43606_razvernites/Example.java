package school.faang.sprin1.task_43606_razvernites;

import java.lang.reflect.Array;

public class Example {



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
        if (Array.getLength(array) == 0){
            System.out.println("Массив не может быть пустым");
        }else if(array == null){
            System.out.println("Пустая ссылка");
        }else {
            System.out.print(array.getClass() + " ");
            int lenght = Array.getLength(array);
            for (int i = 0; i < lenght; i++) {
                Object element = Array.get(array, i);
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }
}

