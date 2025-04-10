package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] reverse = Example.reverse(numbers);

        System.out.println(Arrays.toString(reverse));
    }
