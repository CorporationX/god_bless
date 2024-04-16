package faang.school.godbless.Task_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(evenNumbers(new ArrayList<>(Arrays.asList(1,2,3,5.6,4L,8,20))));
    }

    static int evenNumbers(List<Number> numbers) {
        return numbers.stream().
                mapToInt(Number::intValue).
                filter(number -> (number) % 2 == 0).
                reduce(0, Integer::sum);
    }
}
