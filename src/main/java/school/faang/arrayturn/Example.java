package school.faang.arrayturn;

public class Example {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array before");
        Example.printArray(array);
        Example.turnArray(array);
        System.out.println("\nArray after");
        Example.printArray(array);
    }

    private static void turnArray(int[] array) {
        if (array.length == 0) {
            return;
        }
        int var;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            var = array[left];
            array[left] = array[right];
            array[right] = var;
            left++;
            right--;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
