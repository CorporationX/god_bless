package school.faang.reverse;

import java.util.Arrays;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var integers = new int[] {1, 2, 3, 4, 5};
        var reversed = Example.reverse(integers);
        System.out.println(Arrays.toString(reversed));
    }
}
