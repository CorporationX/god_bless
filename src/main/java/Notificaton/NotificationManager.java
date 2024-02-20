package Notificaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void registerFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }
    public void sendNotification(Notification notification) {
        boolean shouldSend = filters.stream().allMatch(filter -> filter.test(notification));
        if (shouldSend) {
            Consumer<Notification> handler = handlers.get(notification.getType());
            if (handler == null) {
                System.err.println("Обработчик для типа нотификации " + notification.getType() + " не найден!");
                return;
            }
            handler.accept(notification);
        }
    }
    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        return notificationManager;
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();
        notificationManager.registerFilter(notification -> !notification.getType().equals("sms"));
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        Map<String, Predicate<Notification>> filter = new HashMap<>();
        filter.put("filtration", notification -> false);
    }
}
