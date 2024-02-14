package faang.school.godbless.Meta;

import faang.school.godbless.Meta.Notification;

import java.util.HashMap;
import java.util.Map;


public class NotificationManager {


    private String notificationId;
    private String message;

    private Map<String, Consumer<Notification>>notificationHandlers=new HashMap<>();
    @FunctionalInterface
    public interface Consumer<Notification> {
        void accept(Notification param);
    }

    public void registerHandler(String type, Consumer<Notification> handler){
        notificationHandlers.put(type, handler);
    }
    public void sendNotification(Notification notification){
        notificationHandlers.get(notification.getType()).accept(notification);
    }

}