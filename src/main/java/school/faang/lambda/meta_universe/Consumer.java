package school.faang.lambda.meta_universe;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T param);
}
