package school.faang.bjs279242;

public class Example {
    public void revers(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int end = array.length - (i + 1);
            int num = array[i];
            array[i] = array[end];
            array[end] = num;
        }
    }
}
