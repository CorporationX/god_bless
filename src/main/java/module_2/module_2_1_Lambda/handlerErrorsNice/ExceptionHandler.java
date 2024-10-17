package module_2.module_2_1_Lambda.handlerErrorsNice;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T get() throws Exception;
}
