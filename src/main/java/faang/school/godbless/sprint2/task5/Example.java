package faang.school.godbless.sprint2.task5;

public class Example {
    public void reverse(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
