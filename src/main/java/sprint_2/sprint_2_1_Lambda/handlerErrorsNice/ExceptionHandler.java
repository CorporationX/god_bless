package sprint_2.sprint_2_1_Lambda.handlerErrorsNice;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T get() throws Exception;
}
