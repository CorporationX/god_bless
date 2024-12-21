package school.faang.task49866;

@FunctionalInterface
public interface HandInterrupted<T> {
    T test() throws InterruptedException;
}
