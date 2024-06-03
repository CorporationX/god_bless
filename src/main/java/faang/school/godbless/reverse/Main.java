package faang.school.godbless.reverse;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();
        List<Integer> integerListForReversing = Arrays.asList(1, 2, 3, 4, 5);
        example.reverse(integerListForReversing);

        System.out.println(integerListForReversing);
    }
}
