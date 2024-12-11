package school.faang.sprint2.tast_bjs246757;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ToString
public class NotificationManager {
    Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {

        if (type != null && notificationConsumer != null) {
            notificationHandlers.put(type, notificationConsumer);
        } else {
            System.out.println("Тип или функция не должны быть нулевыми: null");
        }
    }

    public void sendNotification(Notification notification) {
        if (notification != null) {
            Consumer<Notification> notificationConsumer = notificationHandlers.get(notification.getType());

            if (notificationConsumer != null) {
                notificationConsumer.accept(notification);
            } else {
                System.out.println("Такого события не существует: " + notification.getType());
            }
        } else {
            System.out.println("Notification ну должно быть нулевым: null");
        }
    }
}
