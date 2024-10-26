package school.faang.bjs2_39094;

import java.util.List;
import java.util.stream.IntStream;

public record School(String name, List<Student> students) {

    public int getTotalPoints() {
        return students.stream().flatMapToInt(s -> IntStream.of(s.getPoints())).sum();
    }
}
