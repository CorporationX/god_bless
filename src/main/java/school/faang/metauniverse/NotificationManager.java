package school.faang.metauniverse;

import school.faang.metauniverse.Notification.NotificationType;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlers = new EnumMap<>(NotificationType.class);
    private final Predicate<Notification> contentFilter = notification ->
            !notification.getMessage().contains("нецензурная лексика");
    private final Function<Notification, Notification> contentCorrector = notification ->
            new Notification(notification.getType(), notification.getMessage() + " Meta inc.");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification);

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
        NotificationManager notificationManager = new NotificationManager();

        NotificationType[] notificationTypes = {
                NotificationType.EMAIL,
                NotificationType.SMS,
                NotificationType.PUSH
        };

        String[] message = {
                "Ваш аккаунт активирован!",
                "Ваш пароль изменен!",
                "У вас новое сообщение!"
        };

        for (NotificationType type : notificationTypes) {
            notificationManager.registerHandler(type, notification ->
                    System.out.println(type.name() + ": " + notification.getMessage())
            );
        }

        for (int i = 0; i < notificationTypes.length; i++) {
            Notification notification = new Notification(notificationTypes[i], message[i]);
            notificationManager.sendNotification(notification);
        }
    }
}