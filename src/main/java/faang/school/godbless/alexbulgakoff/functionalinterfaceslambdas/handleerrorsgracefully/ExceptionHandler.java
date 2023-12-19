package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.handleerrorsgracefully;

/**
 * @author Alexander Bulgakov
 */
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
