package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_18_meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public final Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> consumer){
        notificationMap.put(notification, consumer);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> consumer = notificationMap.get(notification.type());
        consumer.accept(notification);
    }
}
