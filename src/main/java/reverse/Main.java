package reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] digits = new int[]{1, 2, 3, 4, 5};

        example.reverse(digits);
        System.out.println(Arrays.toString(digits));
    }
}
