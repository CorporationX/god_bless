package faang.school.godbless;

public class Example {
    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 7, 8, 12};
        Example example = new Example();
        reverse(arrayInt);
        for(int i: arrayInt) {
            System.out.println(i);
        }
    }

    public static void reverse(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }

}
