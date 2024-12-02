package school.faang.task_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("BJS2-43623 (Развернитесь!)---------------------------------------------------------------");
        System.out.println("null array: " + Arrays.toString(Example.reverse(null)));
        System.out.println("one element array: " + Arrays.toString(Example.reverse(new int[]{999})));
        System.out.println("many elements array: " + Arrays.toString(Example.reverse(new int[]{0, 1, 2, 3, 4})));
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
