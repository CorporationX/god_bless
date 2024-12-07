package school.faang.sprint2.task47010.manager;

import school.faang.sprint2.task47010.model.MessageType;
import school.faang.sprint2.task47010.model.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<MessageType, Consumer<Notification>> messageHandlers = new HashMap<>();

    public void registerHandler(MessageType messageType, Consumer<Notification> handler)
    {
        messageHandlers.put(messageType, handler);
    }

    public void sendNotification(Notification notification)
    {
        Consumer<Notification> handler = messageHandlers.get(notification.getType());
        if (handler != null)
        {
            handler.accept(notification);
        }else
        {
            System.out.println("System error: unknown message type " + notification.getType());
        }
    }

}
