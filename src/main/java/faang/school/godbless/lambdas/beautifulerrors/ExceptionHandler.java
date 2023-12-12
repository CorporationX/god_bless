package faang.school.godbless.lambdas.beautifulerrors;

@FunctionalInterface
public interface ExceptionHandler<T extends Exception, U> {
    U handleException(T exception);
}
