package school.faang.bjs2_80528;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<String> illegalWords = List.of("ссылке");
        notificationManager.setIllegalWords(illegalWords);

        notificationManager.registerHandler(
                NotificationType.EMAIL,
                notification -> System.out.println(notification.type().name() + ": " + notification.massage()));
        notificationManager.registerHandler(
                NotificationType.SMS,
                notification -> System.out.println(notification.type().name() + ": " + notification.massage()));
        notificationManager.registerHandler(
                NotificationType.PUSH,
                notification -> System.out.println(notification.type().name() + ": " + notification.massage()));

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
