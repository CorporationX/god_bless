package faang.school.godbless.module1.sprint2.task1;


@FunctionalInterface
public interface Calculator<T, U, R> {
    R calculate(T rigthDigit, U leftDigit);
}
