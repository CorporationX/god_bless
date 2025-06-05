package school.faang.bjs279242;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example test = new Example();
        int[] array = new int[]{1, 3, 5, 6, 13, 14};
        int[] rev = test.revers(array);
        System.out.println(Arrays.toString(rev));
    }
}
