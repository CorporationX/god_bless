package school.faang.meta.notification;

import school.faang.util.ParameterUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> consumers;

    public NotificationManager() {
        this.consumers = new HashMap<>();
    }

    public boolean registerHandler(NotificationType type, Consumer<Notification> handler) {
        ParameterUtil.checkToNull(type, "type");
        ParameterUtil.checkToNull(handler, "handler");

        if (consumers.containsKey(type)) {
            System.out.printf("a notification handler for %s type is already registered\n", type);
            return false;
        }

        consumers.put(type, handler);
        return true;
    }

    public void forceRegisterHandler(NotificationType type, Consumer<Notification> handler) {
        ParameterUtil.checkToNull(type, "type");
        ParameterUtil.checkToNull(handler, "handler");

        consumers.put(type, handler);
    }

    public boolean sendNotification(Notification notification) {
        ParameterUtil.checkToNull(notification, "notification");

        if (!handlerIsRegistered(notification)) {
            return false;
        }

        consumers.get(notification.getType()).accept(notification);
        return true;
    }

    public boolean sendNotificationWithFilter(Notification notification, Predicate<Notification> predicate) {
        ParameterUtil.checkToNull(notification, "notification");
        ParameterUtil.checkToNull(predicate, "predicate");

        if (!handlerIsRegistered(notification)) {
            return false;
        }

        if (!predicate.test(notification)) {
            System.out.println("notification fails on demand");
            return false;
        }

        consumers.get(notification.getType()).accept(notification);
        return true;
    }

    public boolean sendNotificationWithProcessing(Notification mainNotification, Function<Notification, Notification> processor) {
        ParameterUtil.checkToNull(mainNotification, "mainNotification");
        ParameterUtil.checkToNull(processor, "processor");

        if (!handlerIsRegistered(mainNotification)) {
            return false;
        }

        Notification processedNotification = processor.apply(mainNotification);
        consumers.get(processedNotification.getType()).accept(processedNotification);
        return true;
    }

    private boolean handlerIsRegistered(Notification notification) {
        var type = notification.getType();
        if (!consumers.containsKey(type)) {
            System.out.printf("the handler for %s type is not registered\n", type);
            return false;
        }

        return true;
    }
}
