package school.faang.task57706.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> notificationTypeConsumer = new HashMap<>();

    void registerHandler(NotificationType type, Consumer<Notification> handler){

    }

    void sendNotification(Notification notification){

    }
}
