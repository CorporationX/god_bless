package school.faang.sprint_2.beautifulMistakes;

public interface ThrowableException<T> {
    T apply() throws Exception;
}
