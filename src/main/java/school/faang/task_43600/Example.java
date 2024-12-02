package school.faang.task_43600;

public class Example {
    public void reverse(int[] array) {
        if (array.length > 2) {
            for (int count = 0, reverseCount = array.length - 1; count < reverseCount; count++, reverseCount--) {
                int buffer = array[count];
                array[count] = array[reverseCount];
                array[reverseCount] = buffer;
            }
        }
    }

    public void printArray(int[] array) {
        System.out.println("Array size = " + array.length);
        for (int num : array) {
            System.out.println(String.format("%d", num));
        }
    }
}
