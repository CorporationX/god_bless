package school.faang.bjs2_80528;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class Main {
    private static final List<String> ILLEGAL_WORDS = List.of("ссылке");

    public static void main(String[] args) {
        NotificationManager notificationManager = NotificationManager.builder().withIllegalWords(ILLEGAL_WORDS).build();

        notificationManager.registerHandler(
                NotificationType.EMAIL,
                notification -> log.info("{}: {}", notification.type().name(), notification.massage()));
        notificationManager.registerHandler(
                NotificationType.SMS,
                notification -> log.info("{}: {}", notification.type().name(), notification.massage()));
        notificationManager.registerHandler(
                NotificationType.PUSH,
                notification -> log.info("{}: {}", notification.type().name(), notification.massage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Чек об оплате");
        Notification smsNotification = new Notification(NotificationType.SMS, "Вам доступны бонусы");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Скидки до 70%! Не пропустите.");
        Notification badEmailNotification = new Notification(NotificationType.EMAIL,
                                                             "Для получения выйгрыша перейдите по ссылке");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(badEmailNotification);
    }
}
