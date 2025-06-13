package school.faang.task_79176;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7};
        int[] array4 = {1, 2, 3};
        int[] array5 = {1, 2};

        Example example = new Example();

        example.reverse(array1);
        example.reverse(array2);
        example.reverse(array3);
        example.reverse(array4);
        example.reverse(array5);

    }
}
