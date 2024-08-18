package faang.school.godbless.SecondSprint.BJS2_22050;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> register = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer){
        register.put(type, consumer);
    }
    public void sendNotification(Notification notification){
        register.get(notification.getType()).accept(notification);
    }
}
