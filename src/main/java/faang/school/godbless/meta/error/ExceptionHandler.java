package faang.school.godbless.meta.error;

@FunctionalInterface
interface ExceptionHandler<T>  {
    T handle(Exception e);
}
