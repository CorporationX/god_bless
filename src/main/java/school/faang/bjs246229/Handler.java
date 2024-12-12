package school.faang.bjs246229;

@FunctionalInterface
public interface Handler<T> {
    T handler(Exception e);
}
