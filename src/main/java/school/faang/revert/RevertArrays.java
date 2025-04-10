package school.faang.revert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class RevertArrays {

    public static List<Integer> reversArrays(Integer[] numberArrays) {
        return Stream.of(numberArrays).sorted(Comparator.reverseOrder())
                .toList();
    }
}
