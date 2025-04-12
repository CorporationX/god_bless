package school.faang.lambdas;

import lombok.extern.slf4j.Slf4j;
import school.faang.lambdas.corrector.Corrector;
import school.faang.lambdas.corrector.DefaultCorrector;
import school.faang.lambdas.moderator.Moderator;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


@Slf4j
public class NotificationManager {

    public final Moderator moderator;
    public final Corrector corrector;
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public NotificationManager(Moderator moderator) {
        this.moderator = moderator;
        this.corrector = new DefaultCorrector();
    }

    public NotificationManager(Moderator moderator, Corrector corrector) {
        this.moderator = moderator;
        this.corrector = corrector;
    }

    public NotificationManager registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
        return this;
    }

    public void sendNotification(Notification notification) {
        if (moderator.isDecentMessage(notification)) {
            Consumer<Notification> messageHandler = notificationHandlers.get(notification.type());
            if (messageHandler == null) {
                throw new NoSuchElementException(
                        "For notification type %s no handler added!".formatted(notification.type()));
            }
            messageHandler.accept(corrector.correct(notification));
        }
    }
}
