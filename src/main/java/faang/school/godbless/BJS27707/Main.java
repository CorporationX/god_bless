package faang.school.godbless.BJS27707;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        Example.reverse(array);
        System.out.println(Arrays.toString(array));
    }
}
