package school.faang.lambda.meta_universe;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlerContainer = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type != null & handler != null) {
            handlerContainer.put(type, handler);
        } else {
            log.info("Один из параметров null: type = {}, handler = {}", type, handler);
        }
    }

    public void sendNotification(Notification notification) {
        MessageValidator validator = new MessageValidator();
        if (validator.test(notification)) {
            handlerContainer.get(notification.getType()).accept(notification);
        }
    }

    public Notification fillSender(Notification notification, Function<Notification, Notification> signFromSender) {
        if (signFromSender != null) {
            return signFromSender.apply(notification);
        } else {
            log.info("You dont have registered message sender");
            return notification;
        }
    }


}
