package faang.school.godbless.sprint3.lambda.task2;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    T join(List<T> vector);
}
