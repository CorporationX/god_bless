package school.faang.task_79176;


public class Example {
    public void reverse(int[] array) {

        int lengthArray = array.length;

        for (int i = 0; i < (array.length / 2); i++) {
            int buffer = array[i];
            array[i] = array[lengthArray - 1];
            array[lengthArray - 1] = buffer;
            lengthArray--;
        }

        for (int i : array) {
            System.out.printf(i + ", ");
        }
        System.out.println();

    }
}

