package school.faang.csv;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vectors);
}
