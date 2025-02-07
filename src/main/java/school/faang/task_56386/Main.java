package school.faang.task_56386;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        final int[] array = {1, 2, 3, 4, 5};
        final int[] array2 = {78};
        final int[] array3 = new int[0];

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        example.reverse(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        example.reverse(array2);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
        example.reverse(array3);
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
    }
}
