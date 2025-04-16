package school.faang.sprinttwo.metauniverse;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers =
            new EnumMap<>(NotificationType.class);
    private final Map<NotificationType, List<Function<Notification, Notification>>> correctors =
            new EnumMap<>(NotificationType.class);

    public void registerCorrector(NotificationType type, Function<Notification, Notification> corrector) {
        correctors.computeIfAbsent(type, k -> new ArrayList<>()).add(corrector);
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        List<Function<Notification, Notification>> correctorList = correctors.get(notification.getNotificationType());
        Notification correctedNotification = notification;
        if (correctorList != null) {
            for (Function<Notification, Notification> corrector : correctorList) {
                correctedNotification = corrector.apply(correctedNotification);
            }
        }

        Consumer<Notification> handler = handlers.get(correctedNotification.getNotificationType());
        if (handler != null) {
            handler.accept(correctedNotification);
        } else {
            System.out.printf("Нет обработчика для типа: %s", correctedNotification.getNotificationType());
        }
    }
}