package school.faang.meta;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Notification notification1 = new Notification(NotificationType.EMAIL, "massage in Email");
        Notification notification2 = new Notification(NotificationType.PUSH, "massage in Push");
        Notification notification3 = new Notification(NotificationType.SMS, "massage in SMS");

        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL, message ->
                log.info("Отправить на почту: {}", message.massage()));
        manager.registerHandler(NotificationType.PUSH, message ->
                log.info("Вывести пуш уведомлением: {}", message.massage()));
        manager.registerHandler(NotificationType.SMS, message ->
                log.info("Отправить по SMS: {}", message.massage()));

        manager.sendNotification(notification1);
        manager.sendNotification(notification2);
        manager.sendNotification(notification3);
    }
}
