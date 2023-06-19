package faang.school.godbless;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void addFilters(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void sendNotification(Notification notification) {
        var handler = handlers.get(notification.getType());
        boolean acceptance = filters.stream().allMatch(filter -> filter.test(notification));
        if (handler != null && acceptance) {
            handler.accept(notification);
        }
    }

    public static void main(String... args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("badWord Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.addFilters(notification -> !notification.getMessage().contains("badWord"));
        notificationManager.addFilters(notification -> notification.getMessage().length() < 100);

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "badWord Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
