package school.faang.secondStream.BJS2_33451;

@FunctionalInterface
public interface TryAction<R> {
    R action() throws Exception;
}