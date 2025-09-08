package school.faang.bjs2_88736;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Getter
@ToString
public class NotificationManager {
    private static final Set<String> BAN_WORD = Set.of("fuck", "shit", "bitch");
    private final Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> appeal = notificationHandler.get(notification.getType());

        if (Objects.nonNull(appeal)) {
            examinationFilterWord(notification, n -> BAN_WORD.stream()
                    .anyMatch(n.getMessage()
                            .toLowerCase()::contains));
        } else {
            System.out.printf("%s - this handler has not been created yet \n", notification.getType());
        }
    }

    private void examinationFilterWord(Notification notification, Predicate<Notification> ban) {
        if (ban.test(notification)) {
            System.out.println("A forbidden word was used!!! BAAAAAN!!!!");
        } else {
            System.out.println(("%s | With love your META").formatted(notification.getMessage()));
        }
    }
}

