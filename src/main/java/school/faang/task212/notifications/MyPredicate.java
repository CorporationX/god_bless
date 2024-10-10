package school.faang.task212.notifications;

import java.util.Set;

@FunctionalInterface
public interface MyPredicate<U, T> {
    boolean test(Set<U> set, T t);
}
