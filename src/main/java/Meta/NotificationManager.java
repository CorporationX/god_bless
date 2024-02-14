package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private static Map <String, Consumer<Notification>> map = new HashMap <>();
    public static void registerHandler (String type, Consumer <Notification> consumer){
            map.put(type, consumer);
    }
    public static void sendNotification (Notification notification ){
        map.get(notification.getType()).accept(notification);
    }
    public static void AntiHateFanngSchool (Map <String,Consumer<Notification>> map){
        map.entrySet().stream().filter(elements -> elements.getKey() == "bad review");
    }
}

