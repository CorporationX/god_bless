package school.faang;

import school.faang.reverse.Example;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] array = {1, 2, 3, 4, 5};
        example.reverse(array);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
