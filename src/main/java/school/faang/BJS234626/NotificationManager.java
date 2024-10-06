package school.faang.BJS234626;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    public static Map<String, Notification> notificationMap = new HashMap();

    public void registerHandler(String alert, Notification notification) {
//        notificationMap.put(alert, noti);
        System.out.println(alert + notification.getMessage());
    }
}
