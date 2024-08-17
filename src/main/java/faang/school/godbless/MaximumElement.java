package faang.school.godbless;

import java.util.List;

public class MaximumElement {
    public static Integer findMaximumElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .get();
    }
}