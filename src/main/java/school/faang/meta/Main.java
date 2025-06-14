package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static school.faang.meta.NotificationType.EMAIL;
import static school.faang.meta.NotificationType.PUSH;
import static school.faang.meta.NotificationType.SMS;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(
                EMAIL, (Consumer<Notification>) n -> log.info("Email: {}", n)
        );

        notificationManager.registerHandler(
                SMS, (Consumer<Notification>) n -> log.info("SMS: {}", n)
        );
        notificationManager.registerHandler(
                SMS, (Predicate<Notification>) n -> !n.message().contains("badWord")
        );

        notificationManager.registerHandler(
                PUSH, (Consumer<Notification>) n -> log.info("Push Notification: {}", n)
        );
        notificationManager.registerHandler(
                PUSH, (UnaryOperator<Notification>) n -> new Notification(n.type(), n.message() + " by Meta")
        );

        // Отправка оповещений
        Notification emailNotification = new Notification(EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(SMS, "Ваш пароль изменен");
        Notification badSsmsNotification = new Notification(SMS, "Ваш пароль изменен badWord");
        Notification pushNotification = new Notification(PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(badSsmsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
