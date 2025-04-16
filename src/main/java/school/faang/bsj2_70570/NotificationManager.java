package school.faang.bsj2_70570;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class NotificationManager {

    private Map<NotificationType, Consumer<Notification>> handlers;
    private Map<NotificationType, Predicate<Notification>> profanityFilters;
    private Map<NotificationType, Function<Notification, Notification>> messageChanger;

    public NotificationManager() {
        this.handlers = new HashMap<>();
        this.profanityFilters = new HashMap<>();
        this.messageChanger = new HashMap<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handlers.putIfAbsent(type, handler);
    }

    public void registerProfanityFilter(NotificationType type, Predicate<Notification> filter) {
        this.profanityFilters.putIfAbsent(type, filter);
        boolean isTypeAdded = profanityFilters.entrySet().stream()
                .anyMatch(entry -> profanityFilters.containsKey(entry.getKey()));
        boolean isFilterAdded = profanityFilters.entrySet().stream()
                .anyMatch(entry -> profanityFilters.containsKey(entry.getValue()));
        if (isTypeAdded || isFilterAdded) {
            System.out.println("Profanity Filter Added");
        } else {
            System.out.println("Adding Profanity Filter failed");
        }
    }

    public void registerMessageChanger(NotificationType type, Function<Notification, Notification> changer) {
        this.messageChanger.putIfAbsent(type, changer);
    }

    public void sendNotification(Notification notification) {
        if (this.handlers.containsKey(notification.getType())) {
            this.handlers.get(notification.getType()).accept(notification);
        } else {
            throw new NoSuchElementException("No handler found for type " + notification.getType());
        }
    }

    public boolean sendProfanityNotification(Notification notification) {
        if (this.profanityFilters.containsKey(notification.getType())) {
            return this.profanityFilters.get(notification.getType()).test(notification);
        } else {
            throw new NoSuchElementException(
                    "No profanity filter found for notification type: " + notification.getType()
            );
        }
    }


    public void changeNotificationMessage(Notification notification) {
        if (this.messageChanger.containsKey(notification.getType())) {
            this.messageChanger.get(notification.getType()).apply(notification);
        } else {
            throw new NoSuchElementException(
                    "No profanity filter found for notification type: " + notification.getType()
            );
        }
    }

}



