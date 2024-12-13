package school.faang.bjs246807;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    final Map<String, Consumer<Notification>> handlerData = new HashMap<>();

    public void registerHandler(String typeMessage, Consumer<Notification> messageHandler) {
        if (typeMessage == null || messageHandler == null) {
            throw new IllegalArgumentException("Message or message handler can not be null");
        }
        handlerData.put(typeMessage, messageHandler);
    }

    public Consumer<Notification> sendMessage(Notification notification) {
        Consumer<Notification> notificationConsumer = handlerData.get(notification.getType());
        if (notificationConsumer == null) {
            throw new NoSuchElementException("No handler for this type message");
        }
        notificationConsumer.accept(notification);
        return notificationConsumer;
    }
}
