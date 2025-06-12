package school.faang.error;

public interface Recover<T> {
    T process(Exception e);
}
