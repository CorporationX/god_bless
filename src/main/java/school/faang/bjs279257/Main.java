package school.faang.bjs279257;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello BJS2-79257!");
        var numbers = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(numbers));
        Example.reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
