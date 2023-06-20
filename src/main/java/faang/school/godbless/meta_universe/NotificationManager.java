package faang.school.godbless.meta_universe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private Map<NotificationType, Consumer> notificationHandlerMap = new HashMap<>();
    private Set<Predicate<Notification>> filters = new HashSet<>();
    private Map<NotificationType, Function<String, String>> correctionMap = new HashMap<>();


    public void registerHandler(NotificationType notificationType, Consumer<Notification> consumer){
        notificationHandlerMap.put(notificationType, consumer);
    }

    public void addFilter(Predicate<Notification> predicate){
        filters.add(predicate);
    }

    public void editNotification(NotificationType notificationType, Function<String, String> function){
        correctionMap.put(notificationType, function);
    }

    public void sendNotification(Notification notification){
        Optional.ofNullable(notificationHandlerMap.get(notification.getNotificationType()))
                .ifPresent(handler -> {
                    boolean isValid = filters.stream().allMatch(message -> message.test(notification));
                    if (isValid){
                        handler.accept(notification);
                    } else {
                        handler.accept(editMessage(notification));
                    }
                });
    }

    private Notification editMessage(Notification notification){
        Optional.ofNullable(correctionMap.get(notification.getNotificationType()))
                .ifPresent(correctionFunction -> {
                    String correctedMessage = correctionFunction.apply(notification.getMessage());
                    notification.setMessage(correctedMessage);
                });

        return notification;
    }
}
