package MetaUniverse_BJS2_34890;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Обработчик для типа оповещения \"" + notification.getType() + "\" не найден.");
        }
    }
}
