package school.faang.reverse;

public class Example {
    public void reverse(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (array.length == 0) {
            return;
        }

        int temp;
        int length = array.length - 1;

        for (int i = 0; i <= length / 2; i++) {
            temp = array[i];
            array[i] = array[length - i];
            array[length - i] = temp;
        }
        Number [] numbers = new Number [] {34, 45, 67, 444, -435};

    }
}
