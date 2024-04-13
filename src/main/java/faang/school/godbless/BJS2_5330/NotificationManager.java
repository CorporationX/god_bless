package faang.school.godbless.BJS2_5330;

import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public void registerHandler(String type, Consumer<Notification> handler, Map<String, Consumer<Notification>> handlers){
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification, Map<String, Consumer<Notification>> handlers){
        ExceptionFromRemoteServer.withErrorHandling(i -> handlers.get(notification.getType()).accept(notification),
                NullPointerException.class).accept(notification);
    }
}
