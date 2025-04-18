package school.faang.bjs2_69339;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        var array = new ArrayList<Integer>();
        array.add(11);
        array.add(32);
        array.add(76);
        array.add(99);
        array.add(713);
        var arrayCopy = new ArrayList<>(array);

        Example.reverseNaive(array);
        Example.reverse(arrayCopy);

        System.out.println(array);
        System.out.println(arrayCopy);
    }
}