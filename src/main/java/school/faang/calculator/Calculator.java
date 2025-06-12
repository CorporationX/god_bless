package school.faang.calculator;

import java.util.function.BinaryOperator;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
@FunctionalInterface
public interface Calculator<T> extends BinaryOperator<T> {
}
