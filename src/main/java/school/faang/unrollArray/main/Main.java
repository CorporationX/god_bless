package school.faang.unrollArray.main;

import school.faang.unrollArray.service.Example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        Example.reverse(num);
        System.out.println(Arrays.toString(num));
    }
}
