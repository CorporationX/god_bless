package faang.school.godbless.sprint_3.task_1;

@FunctionalInterface
public interface SpellAction<T, R> {
    T apply(R result);

}

