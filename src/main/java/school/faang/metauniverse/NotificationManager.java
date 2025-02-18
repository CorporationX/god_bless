package school.faang.metauniverse;

import school.faang.metauniverse.Notification.NotificationType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private static final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private static final Predicate<Notification> contentFilter;
    private static final Function<Notification, Notification> contentCorrector;

    static {
        contentFilter = notification -> !notification.getMessage().contains("нецензурная лексика");
        contentCorrector = notification -> new Notification(
                notification.getType(),
                notification.getMessage() + " Meta inc."
        );
    }

    static void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    static void sendNotification(Notification notification) {

        if (!contentFilter.test(notification)) {
            System.out.println("Сообщение заблокировано из-за недопустимого содержания: " + notification.getMessage());
            return;
        }

        Notification correctedNotification = contentCorrector.apply(notification);

        Consumer<Notification> handler = handlers.get(correctedNotification.getType());
        if (handler != null) {
            handler.accept(correctedNotification);
        } else {
            System.out.println("Не зарегистрирован обработчик для типа уведомления: "
                    + correctedNotification.getType());
        }
    }

    public static void main(String[] args) {

        registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        sendNotification(emailNotification);
        sendNotification(smsNotification);
        sendNotification(pushNotification);

    }
}
