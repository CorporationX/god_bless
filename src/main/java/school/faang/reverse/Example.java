package school.faang.reverse;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Example {

    public static int[] reverse(int[] integers) {
        var tmp = 0;
        for (int i = 0; i < integers.length / 2; i++) {
            tmp = integers[i];
            integers[i] = integers[integers.length - i - 1];
            integers[integers.length - i - 1] = tmp;
        }
        return integers;
    }
}
