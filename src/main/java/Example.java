public class Example {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        reverse(array);

        for (int i : array) {
            System.out.print(i + " "); // 9 8 7 6 5 4 3 2 1 0
        }
    }

    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int index = array[i];
            int lastIndex = array[array.length - 1 - i];

            array[i] = array[lastIndex];
            array[lastIndex] = index;
        }
    }
}
