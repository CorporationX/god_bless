package school.faang;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Default massive: ");
        int[] defaultMassive = {0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(defaultMassive));
        Example.reverse(defaultMassive);
        System.out.println(Arrays.toString(defaultMassive));

        System.out.println("Null massive: ");
        int[] nullMassive = null;
        System.out.println(Arrays.toString(nullMassive));
        Example.reverse(nullMassive);
        System.out.println(Arrays.toString(nullMassive));

        System.out.println("Empty massive: ");
        int[] emptyMassive = {};
        System.out.println(Arrays.toString(emptyMassive));
        Example.reverse(emptyMassive);
        System.out.println(Arrays.toString(emptyMassive));

        System.out.println("One element massive: ");
        int[] oneElementMassive = {};
        System.out.println(Arrays.toString(oneElementMassive));
        Example.reverse(oneElementMassive);
        System.out.println(Arrays.toString(oneElementMassive));
    }
}
