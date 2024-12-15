package school.faang.moduleone.sprinttwo.task_43535;

import java.util.HashSet;
import java.util.Set;

@FunctionalInterface
public interface NotificationFilter<T> {
    Set<String> BANNED_WORDS = new HashSet<>();

    Notification filter(Notification notification);

}
