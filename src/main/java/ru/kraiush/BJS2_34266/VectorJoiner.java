package ru.kraiush.BJS2_34266;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
