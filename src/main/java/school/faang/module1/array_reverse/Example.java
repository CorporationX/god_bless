package school.faang.module1.array_reverse;

public class Example {

    public int[] reverse(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("null array is illegal");
        }

        if (array.length <= 1) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        return array;
    }
}
