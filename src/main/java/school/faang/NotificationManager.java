package school.faang;

import java.util.HashMap;

public class NotificationManager {
    private HashMap<String, Consumer> handlerManager;
    public NotificationManager(){
        handlerManager = new HashMap<>();
    }

    public void registerHandler(String identifier, Consumer<Notification> consumer) {
        handlerManager.put(identifier,consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = handlerManager.get(notification.getType());
        consumer.accept(notification);
    }

}


