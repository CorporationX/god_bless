package school.faang.bjs2_71899;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.function.Consumer;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager(new HashMap<>());
        Consumer<Notification> consumerString = notif -> System.out.printf(
                "%s: \"%s\" был отправлено\n",
                notif.getType(),
                notif.getMessage()
        );
        Consumer<Notification> consumerLog = notif -> log.info(
                "Сообщение \"" + notif.getMessage() + "\" было отправлено через " + notif.getType()
        );

        manager.registerHandler(NotificationType.PUSH, consumerString);
        manager.registerHandler(NotificationType.EMAIL, consumerString);
        manager.registerHandler(NotificationType.SMS, consumerLog);

        manager.sendNotification(new Notification(NotificationType.EMAIL, "Привет буткэмп!"));
        manager.sendNotification(new Notification(NotificationType.SMS, "Скоро дейлик!"));
        manager.sendNotification(new Notification(NotificationType.TELEPORT, "Пиу!"));
    }
}
