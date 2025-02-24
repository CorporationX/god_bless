package school.faang.reverse;

public class Example {
    public void reverse(int[] array) {
       for (int i = 0; i < array.length / 2; i ++) {
           int temp = array[i];
           array[i] = array[array.length - i - 1];
           array[array.length - i - 1]  = temp;
       }
    }
}
