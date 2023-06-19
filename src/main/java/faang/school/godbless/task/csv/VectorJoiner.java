package faang.school.godbless.task.csv;

import java.util.List;

public interface VectorJoiner<T> {
    T join(List<T> vector);
}
