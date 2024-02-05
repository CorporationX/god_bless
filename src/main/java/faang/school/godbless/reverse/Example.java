package faang.school.godbless.reverse;

public class Example {
    public static int[] reverse(int[] array){
        for (int i = 0; i < array.length / 2; i++){
            int tmp = array[array.length-i-1];
            array[array.length-i-1] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}
