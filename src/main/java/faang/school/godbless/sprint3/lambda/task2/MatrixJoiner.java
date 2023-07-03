package faang.school.godbless.sprint3.lambda.task2;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {

    T join(List<List<T>> matrix);
}
