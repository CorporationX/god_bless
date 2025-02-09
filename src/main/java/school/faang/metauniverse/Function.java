package school.faang.metauniverse;

@FunctionalInterface
public interface Function<U, V> {
    U apply(V param);
}
