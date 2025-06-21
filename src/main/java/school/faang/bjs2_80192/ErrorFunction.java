package school.faang.bjs2_80192;

@FunctionalInterface
public interface ErrorFunction<T> {
    T action(Exception e);
}
