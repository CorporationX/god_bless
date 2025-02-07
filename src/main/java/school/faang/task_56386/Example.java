package school.faang.task_56386;

public class Example {
    public int[] reverse(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("array is null or empty");
        } else if (array.length <= 1) {
            return array;
        } else {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
        return  array;
    }
}
