package faang.school.godbless.HandleErrors;

@FunctionalInterface
public interface OperationCall<T> {
    T call() throws Exception;
}
