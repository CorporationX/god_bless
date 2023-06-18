package faang.school.godbless;

import faang.school.godbless.turnAround.Example;

public class Application {
    public static void main(String... args) {
        int[] array = new int[] {1, 2, 4, 7};
        Example example = new Example();
        array = example.reverse(array);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
