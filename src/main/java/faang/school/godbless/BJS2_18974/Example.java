package faang.school.godbless.BJS2_18974;


public class Example {

     public static void reverse(Integer[] array) {
         for (int i = 0; i < array.length / 2; i++){
             int temp = array[i];
             array[i] = array[array.length - 1 - i];
             array[array.length - 1 - i] = temp;
         }
     }
}
