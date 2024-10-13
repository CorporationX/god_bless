package school.faang.BJS2_33451;

@FunctionalInterface
public interface TryAction<R> {
    R action() throws Exception;
}