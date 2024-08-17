package faang.school.godbless.MetaUniverse;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlersByTypes = new HashMap<>();


    public void registerHandler(String notificationType, Consumer<Notification> consumer, Predicate<String> checkRestrictedWords) {
        if (checkRestrictedWords.test(notificationType)) {
            handlersByTypes.put(notificationType, consumer);
        }
        else {
            System.out.println("ээээ дети смотртят");
        }
    }

    public void sendNotification(Notification notification) {
        if (handlersByTypes.containsKey(notification.getType())) {
            System.out.println(notification.getType() + ": " + notification.getMessage());
            handlersByTypes.get(notification.getType()).accept(notification);
        }
        else {
            System.out.println("нету такой нотификации");
        }
    }
}
