package faang.school.godbless.Meta;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    Map<String,Consumer> commands = new HashMap<>();
    public void registerHandler(String type, Consumer consumer){
        commands.put(type,consumer);
    }

    public void sendNotification(Notification notification){
        commands.get(notification.getType()).act(notification);
    }
}
