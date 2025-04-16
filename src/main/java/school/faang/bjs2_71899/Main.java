package school.faang.bjs2_71899;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.logging.Logger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Consumer<Notification> sendMessageHandler = notif -> Logger.getLogger("Send Message Log").info(
                "Сообщение \"" + notif.getMessage() + "\" было отправлено через " + notif.getType()
        );

        manager.registerHandler(NotificationType.PUSH, null);
        manager.registerHandler(NotificationType.SMS, sendMessageHandler);

        log.info("Количество обработчиков {}", manager.getNotificationHandlers().size());

        manager.sendNotification(new Notification(NotificationType.PUSH, "Привет буткэмп!"));
        manager.sendNotification(new Notification(NotificationType.SMS, "Скоро дейлик!"));
        manager.sendNotification(new Notification(NotificationType.EMAIL, "Пора решать задачи!"));
    }
}
