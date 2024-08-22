package faang.school.godbless;

import java.util.List;
import java.util.Optional;

public class TheSmallestElementInTheList {
    public static Optional<Integer> smallestElementInTheList(List<Integer> list, int number) {
        return list.stream()
                .filter(s -> s > number)
                .min(Integer::compareTo);
    }
}