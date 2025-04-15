package school.faang.meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> mapHandler = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        mapHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (!isCorrectMassage(massage -> Arrays.asList(massage.split(" ")).contains("плохо"),
                notification.massage())) {
            mapHandler.get(notification.type()).accept(addMassage(notification1 ->
                    new Notification(notification.type(),
                            notification1.massage() + " @BadCompany prodaction"), notification));
        }
    }

    public boolean isCorrectMassage(Predicate<String> predicate, String massage) {
        return predicate.test(massage);
    }

    public Notification addMassage(Function<Notification, Notification> function, Notification notification) {
        return function.apply(notification);
    }
}
