package faang.school.godbless.sprint_3.task_777;

@FunctionalInterface
public interface MessageFilter<S> {
    boolean filter(String m);
}