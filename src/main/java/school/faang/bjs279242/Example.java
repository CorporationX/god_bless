package school.faang.bjs279242;

public class Example {
    public int[] revers(int[] array) {
        int[] result = new int[array.length];
        for(int i = 1; i < array.length; i++) {
            result[i] = array[array.length - i];
        }
        return result;
    }
}
