package reverse;

public class Example {
    public static void reverse(int[] array)  {
        if (array == null) {
            throw new NullPointerException("Array is null!");
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
