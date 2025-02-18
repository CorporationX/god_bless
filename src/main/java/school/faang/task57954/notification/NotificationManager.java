package school.faang.task57954.notification;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypeHandler = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notificationTypeHandler.putIfAbsent(type, handler);
    }

    public void sendNotification(@NonNull Notification notification) {
        if (checkBadWords(notification)) {
            System.out.println("Сообщение содержит нецензурное слово");
            return;
        }
        Consumer<Notification> handler = notificationTypeHandler.get(notification.getType());
        handler.accept(notification);
    }

    private boolean checkBadWords(Notification inputNotification) {
        Predicate<Notification> handler = notification -> {
            for (String word : WordFilter.BAD_WORDS.getWord()) {
                if (notification.getMessage().contains(word)) {
                    return true;
                }
            }
            return false;
        };
        return handler.test(inputNotification);
    }

    public Notification addSignatureForMessage(@NonNull Notification notification,
                                               @NonNull Function<Notification, Notification> addCompanyToMessage) {
        return addCompanyToMessage.apply(notification);
    }
}
