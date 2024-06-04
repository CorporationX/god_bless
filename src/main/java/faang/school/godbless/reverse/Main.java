package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();
        Integer[] integerArrayForReversing = {1, 2, 3, 4, 5};

        example.reverse(integerArrayForReversing);

        System.out.println(Arrays.toString(integerArrayForReversing));
    }
}
