package faang.school.godbless.calculator;

import java.util.List;

@FunctionalInterface
public interface Operation<T> {
    int calculate(T num1, T num2) throws IllegalArgumentException;
}