package faang.school.godbless.lambdas.calculator;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Calculator extends BiFunction<Integer, Integer, Integer> {
}
