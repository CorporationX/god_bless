package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static Map<String, Consumer<Notification>> typeToAction = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> action){
        typeToAction.put(type, action);
    }

    public void sendNotification(Notification notification){
        typeToAction.get(notification.getType()).accept(notification);
    }
}
