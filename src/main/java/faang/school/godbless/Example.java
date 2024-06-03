package faang.school.godbless;

public class Example {
    public static int[] revers(int[] array){
        int[] reversInt = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >=0 ; i--) {
            reversInt[index++] = array[i];
        }
        return reversInt;
    }
}
