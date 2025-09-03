package school.faang;

import java.util.Arrays;

import static school.faang.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};

        System.out.println("Было: " + Arrays.toString(num));

        reverse(num);

        System.out.println("Стало: " +  Arrays.toString(num));
    }
}

