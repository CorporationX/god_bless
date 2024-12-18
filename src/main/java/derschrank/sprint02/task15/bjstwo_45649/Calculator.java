package derschrank.sprint02.task15.bjstwo_45649;

import java.util.List;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T doCalc(T a, T b);

    default T calculate(List<T> numbs) throws IllegalArgumentException {
        Calculator<T> calculator = this;
        if (numbs.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        T result = numbs.get(0);
        for (int i = 1; i < numbs.size(); i++) {
            result = calculator.doCalc(result, numbs.get(i));
        }

        return result;
    }
}
