package school.faang.metauniverse;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T param);
}