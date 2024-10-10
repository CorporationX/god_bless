package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static school.faang.meta.InappropriateContentManager.contentCorrection;
import static school.faang.meta.InappropriateContentManager.contentFiltering;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> REGISTERED_HANDLER = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        REGISTERED_HANDLER.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        int stopWords = contentFiltering(notification.getMessage());
        if (stopWords > 2) {
            System.out.println("The notification is invalid due to objectionable content contained in the message.");
        } else {
            Consumer<Notification> handler = REGISTERED_HANDLER.get(notification.getType());
            if (handler != null && stopWords == 0) {
                handler.accept(notification);
            } else if (stopWords == 1 || stopWords == 2) {
                String correctMessage = contentCorrection(notification.getMessage());
                notification.setMessage(correctMessage);
                handler.accept(notification);
            } else {
                System.out.println("Handler not found for type: " + notification.getType());
            }
        }
    }
}
