package faang.school.godbless.lets_bild_csv;

import java.util.List;
@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
