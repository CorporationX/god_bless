package school.faang.lambda.bjs2_87691;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> handlersMap = new HashMap<>();
    private Map<String, Predicate<Notification>> filters = new HashMap<>();
    private List<Function<Notification, Notification>> editors = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlersMap.putIfAbsent(type, handler);
    }

    public void registerFilter(String errorMessage, Predicate<Notification> filter) {
        filters.put(errorMessage, filter);
    }

    public void registerEditor(Function<Notification, Notification> editor) {
        editors.add(editor);
    }

    public void sendNotification(@NonNull Notification notification) {
        for (Map.Entry<String, Predicate<Notification>> filterEntry : filters.entrySet()) {
            if (!filterEntry.getValue().test(notification)) {
                System.out.println(filterEntry.getKey());
                return;
            }
        }

        Notification modifiedNotification = notification;
        for (Function<Notification, Notification> editor : editors) {
            modifiedNotification = editor.apply(notification);
        }

        Consumer<Notification> notificationConsumer = handlersMap.get(modifiedNotification.getType());
        if (notificationConsumer != null) {
            notificationConsumer.accept(modifiedNotification);
        } else {
            System.out.println("No any notifications for type " + modifiedNotification.getType());
        }
    }
}