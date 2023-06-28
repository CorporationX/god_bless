package faang.school.godbless.sprint3.Meta;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    Map<String, Consumer> commands = new HashMap<>();

    public void registerHandler(String type, Consumer consumer) {
        commands.put(type, consumer);
    }

    public void sendNotification(Notification notification) throws NullPointerException {
        if (commands.containsKey(notification.getType())) {
            commands.get(notification.getType()).act(notification);
        } else {
            throw new NullPointerException("this Type is not exist");
        }
    }
}
