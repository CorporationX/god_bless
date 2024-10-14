package school.faang.m1s1.bjs2_31523_Reverse;

public class Example {

    public void reverse(int[] array) {
        int tempHolder;

        for(int i = 0; i < array.length / 2; i++) {
            int lastIndex = array.length - 1 - i;
            tempHolder = array[i];
            array[i] = array[lastIndex];
            array[lastIndex] = tempHolder;
        }
    }
}
