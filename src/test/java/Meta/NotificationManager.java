package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> registerForTypeMap = new HashMap<>();

    public static void registerHandler(String type, Consumer<Notification> handler) {
        registerForTypeMap.put(type, handler);
    }

    public static void sendNotification(Notification notification) {
        String type = notification.getType();
        registerForTypeMap.get(type).accept(notification);
    }



    public static void filter(String message, Function<String, String> filter) {
        System.out.println(filter.apply(message));




    }
}
