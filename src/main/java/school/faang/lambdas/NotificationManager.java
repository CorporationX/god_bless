package school.faang.lambdas;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import school.faang.lambdas.corrector.Corrector;
import school.faang.lambdas.corrector.DefaultCorrector;
import school.faang.lambdas.moderator.Moderator;
import school.faang.lambdas.moderator.NoCheckModerator;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


@Slf4j
@Accessors(chain = true)
public class NotificationManager {

    @Setter
    public Moderator moderator;
    @Setter
    public Corrector corrector;
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public NotificationManager() {
        this.moderator = new NoCheckModerator();
        this.corrector = new DefaultCorrector();
    }

    public NotificationManager registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.notificationHandlers.put(type, handler);
        return this;
    }

    public void sendNotification(Notification notification) {
        if (this.moderator.isDecentMessage(notification)) {
            Consumer<Notification> messageHandler = this.notificationHandlers.get(notification.type());
            if (messageHandler == null) {
                throw new NoSuchElementException(
                        "For notification type %s no handler added!".formatted(notification.type()));
            }
            messageHandler.accept(this.corrector.correct(notification));
        }
    }
}
