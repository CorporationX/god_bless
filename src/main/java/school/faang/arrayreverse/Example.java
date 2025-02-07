package school.faang.arrayreverse;

public class Example {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array before");
        Example.printArray(array);
        Example.reverse(array);
        System.out.println("\nArray after");
        Example.printArray(array);
    }

    private static void reverse(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int tempValue;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            tempValue = array[left];
            array[left] = array[right];
            array[right] = tempValue;
            left++;
            right--;
        }
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
