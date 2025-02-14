package school.faang.naughtwoBJS257668;

@FunctionalInterface
public interface ExceptionTaker<T> {
    T handling(Exception e);
}
