package school.faang.metauniverse;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T param);
}