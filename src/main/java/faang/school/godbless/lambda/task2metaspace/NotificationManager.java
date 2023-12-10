package faang.school.godbless.lambda.task2metaspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private static List<Function<String, String>> filters = new ArrayList<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        for (Function<String, String> filter: filters) {
            String clean = filter.apply(notification.getMessage());
            notification.setMessage(clean);
        }

        String notificationType = notification.getType();
        if (handlers.containsKey(notificationType)) {
            handlers.get(notificationType).accept(notification);
        } else {
            System.out.println("Для типа уведомления не зарегистрирован обработчик: " + notificationType);
        }
    }

    public void registerFilter(Function<String, String> filter) {
        filters.add(filter);
    }
}