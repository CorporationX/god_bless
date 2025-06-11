package school.faang.bjs280575;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> mapManager = new HashMap<>();
    public static Set<String> foulLanguage = Set.of(
            "блин", "хрен", "бака"
    );

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        mapManager.put(type, handler);
    }

    public void sendNotification(Notification notification) {


        if (mapManager.get(notification.getType()) == null) {
            log.warn("Таких уведоблений нету.");
            return;
        } else {
            Predicate<Notification> findFoulLanguage = not -> {
                String massag = not.getMessage();
                List<String> listWord = foulLanguage.stream()
                        .filter(massag.toLowerCase()::contains)
                        .toList();
                if (listWord.isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            };
            Function<Notification, Notification> addSignatur = notif -> {
                String message = notif.getMessage() + "\n\n\nНаша компания желает вам всего самого наилучшего";
                NotificationType type = notif.getType();
                return new Notification(type, message);
            };
            if (findFoulLanguage.test(notification)) {
                System.out.println("На нашем сайте запрещена отправка сообщений с такими словами: " + foulLanguage);
            } else {
                Notification finalNotification = addSignatur.apply(notification);
                mapManager.get(notification.getType()).accept(finalNotification);
                log.info("Сообщение отправлено");
            }

        }
    }

}
