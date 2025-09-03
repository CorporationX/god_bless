package school.faang;

public class Example {
    public static void main(String[] args) {
        int[] numbers = new int[]{0, 1, 2, 3, 4};
        reverse(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Значение индекса " + i + ": " + numbers[i]);
        }
    }

    static void reverse(int[] array) {
        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
    }
}
