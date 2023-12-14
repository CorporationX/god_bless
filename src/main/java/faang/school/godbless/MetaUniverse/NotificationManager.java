package faang.school.godbless.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> typeMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationCustomizer) {
        typeMap.put(type, notificationCustomizer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = typeMap.get(notification.getType());
        if (consumer != null)
            consumer.accept(notification);
        else System.out.println("Сообщений типа \"" + notification.getType() + "\" нет");
    }


}
