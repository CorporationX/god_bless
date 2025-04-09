package school.faang.revers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[] newArray = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(Example.reverse(array)));
        System.out.println(Arrays.toString(Example.reverse(newArray)));

        System.out.println(Arrays.toString(Example.reversVarTwo(array)));
        System.out.println(Arrays.toString(Example.reversVarTwo(newArray)));
    }
}