package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int []result = example.reverse(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));

    }
}
