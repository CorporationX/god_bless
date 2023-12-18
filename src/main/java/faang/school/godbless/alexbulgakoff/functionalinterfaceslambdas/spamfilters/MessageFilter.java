package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.spamfilters;

/**
 * @author Alexander Bulgakov
 */
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
