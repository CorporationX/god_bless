package faang.school.godbless.calculator;

import java.util.List;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T oneNumber, T twoNumber);
}
