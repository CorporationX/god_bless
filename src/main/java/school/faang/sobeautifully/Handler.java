package school.faang.sobeautifully;

@FunctionalInterface
public interface Handler<T> {
    T handler(Exception t);
}
