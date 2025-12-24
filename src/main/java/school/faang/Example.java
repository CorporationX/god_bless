package school.faang;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        Character[] nums = {'1', '2', '3', '4', '5'}; // Массив с числами
        //Вывод массива до реверса
        System.out.println(Arrays.toString(nums));
        reverse(nums);
        //Вывод массива после реверса
        System.out.println(Arrays.toString(nums));
    }
    // Метод реверс
    static void reverse(Character[] sourse) {
        for (int i = 0; i < sourse.length / 2; i++) {
            var temp = sourse[i];
            sourse[i] = sourse[sourse.length - 1- i];
                    sourse[sourse.length - 1 - i]= temp;
            
        }
    }
}
