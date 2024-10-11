package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private InappropriateContentManager contentManager = new InappropriateContentManager();
    private Map<String, Consumer<Notification>> registeredHandler = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        registeredHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String message = notification.getMessage();
        int stopWords = contentManager.contentFiltering(message);
        if (stopWords > 2) {
            System.out.println("The notification is invalid due to objectionable content contained in the message.");
        } else {
            Consumer<Notification> handler = registeredHandler.get(notification.getType());
            if (handler != null && stopWords == 0) {
                handler.accept(notification);
            } else if (handler != null && (stopWords == 1 || stopWords == 2)) {
                String correctMessage = contentManager.contentCorrection(message);
                notification.setMessage(correctMessage);
                handler.accept(notification);
            } else {
                System.out.println("Handler not found for type: " + notification.getType());
            }
        }
    }
}
