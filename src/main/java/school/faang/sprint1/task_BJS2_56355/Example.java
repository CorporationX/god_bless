package school.faang.sprint1.task_BJS2_56355;

public class Example {
    private static final String MAIN = "";

    public void reverse(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (array.length == 0) {
            return;
        }

        String tempValue;
        int length = array.length - 1;

        for (int i = 0; i <= length / 2; i++) {
            tempValue = array[i];
            array[i] = array[length - i];
            array[length - i] = tempValue;
        }
    }
}
