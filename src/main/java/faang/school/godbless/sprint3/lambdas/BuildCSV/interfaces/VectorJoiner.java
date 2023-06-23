package faang.school.godbless.sprint3.lambdas.BuildCSV.interfaces;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
