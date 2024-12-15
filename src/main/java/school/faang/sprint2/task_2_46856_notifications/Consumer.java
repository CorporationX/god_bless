package school.faang.sprint2.task_2_46856_notifications;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T notification);
}
