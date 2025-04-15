package school.faang.bsj2_70570;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class NotificationManager {

    private Map<NotificationType, Consumer<Notification>> notifications;
    private Map<NotificationType, Predicate<Notification>> profanityFilters;
    private Map<NotificationType, Function<Notification, Notification>> messageChanger;

    public NotificationManager() {
        this.notifications = new HashMap<>();
        this.profanityFilters = new HashMap<>();
        this.messageChanger = new HashMap<>();
    }

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.notifications.putIfAbsent(type, handler);
    }

    /*
    Полагаю, что хотели увидеть от меня примерно такую проверку. Я пока не очень хорош в работах с мапами
    (хотя хорошо понимаю, как они работают "под капотом"), с остальными коллекциями всё ок:(.
     */
    public void registerProfanityFilter(NotificationType type, Predicate<Notification> filter) {
        this.profanityFilters.putIfAbsent(type, filter);
        boolean isTypeAdded = profanityFilters.entrySet().stream()
                .anyMatch(entry -> profanityFilters.containsKey(entry.getKey()));
        boolean isFilterAdded = profanityFilters.entrySet().stream()
                .anyMatch(entry -> profanityFilters.containsKey(entry.getValue()));

        if (isTypeAdded || isFilterAdded) {
            System.out.println("Profanity Filter Added");
        }
        System.out.println("Adding Profanity Filter failed");
    }

    public void registerMessageChanger(NotificationType type, Function<Notification, Notification> changer) {
        messageChanger.putIfAbsent(type, changer);
    }

    public void sendNotification(Notification notification) {
        this.notifications.get(notification.getType()).accept(notification);
    }

    public boolean sendProfanityNotification(Notification notification) {
        return profanityFilters.get(notification.getType()).test(notification);
    }

    public void changeNotificationMessage(Notification notification) {
        messageChanger.get(notification.getType()).apply(notification);
    }
}
