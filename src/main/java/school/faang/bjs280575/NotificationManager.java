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
    private Map<NotificationType, Consumer<Notification>> handlersMap = new HashMap<>();
    public static Set<String> foulLanguage = Set.of(
            "блин", "хрен", "бака"
    );


    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlersMap.put(type, handler);
    }

    protected boolean filter(Notification notification) {
        Predicate<Notification> findFoulLanguage = not -> {
            String message = not.getMessage();
            List<String> listWord = foulLanguage.stream()
                    .filter(message.toLowerCase()::contains)
                    .toList();
            if (listWord.isEmpty()) {
                return false;
            } else {

                return true;
            }
        };
        return findFoulLanguage.test(notification);
    }
    protected Notification addSignatureTheMessage(Notification notification) {
        Function<Notification, Notification> addSignature = notif -> {
            String message = notif.getMessage() + "\n\n\nНаша компания желает вам всего самого наилучшего";
            NotificationType type = notif.getType();
            return new Notification(type, message);
        };
        return addSignature.apply(notification);
    }

    public void sendNotification(Notification notification) {

        if (handlersMap.get(notification.getType()) == null) {
            log.warn("Таких уведомлений нету.");
            return;
        } else {
            if (filter(notification)) {
                System.out.println("На нашем сайте запрещена отправка сообщений с такими словами: " + foulLanguage);
            } else {
                Notification finalNotification = addSignatureTheMessage(notification);
                handlersMap.get(notification.getType()).accept(finalNotification);
                log.info("Сообщение отправлено");
            }

        }
    }

}
