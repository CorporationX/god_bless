package school.faang.Bjs2_85563;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray = new int[]{1, 2, 3, 4, 5};
        Example example = new Example();
        int[] reverse = example.reverse(testArray);
        System.out.println(Arrays.toString(reverse));

    }
}
