package school.faang;

import school.faang.reversearray.Example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var reverser = new Example();
        var result = reverser.reverse(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }
}
