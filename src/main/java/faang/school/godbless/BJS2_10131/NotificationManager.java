package faang.school.godbless.BJS2_10131;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String,Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> action){
        map.put(id, action);
    }

    public void sendNotification(Notification notification){
        if (notification.getType() == null || notification.getMessage() == null){
            System.out.println("Некорректное оповещение: "+notification);
            return;
        }
        map.get(notification.getType()).accept(notification);
    }
}
