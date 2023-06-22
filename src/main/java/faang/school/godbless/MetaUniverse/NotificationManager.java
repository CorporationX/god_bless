package faang.school.godbless.MetaUniverse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, Predicate<Notification>> notificationFilters = Map.of(
            "Spam", (notification) -> !notification.getMessage().toLowerCase().contains("spam"),
            "TooShort", (notification -> notification.getMessage().length() > 10));
    private final Map<String, Consumer<Notification>> notificationMap;

    public NotificationManager() {
        this.notificationMap = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notificationMap.put(type, notificationConsumer);
    }

    //Реализация не очень. Сделал просто чтобы показать, что понимаю о чем речь
    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationMap.get(notification.getType());
        if (notificationFilters.values().stream().allMatch(filter -> filter.test(notification))) {
            notificationConsumer.accept(notification);
        } else {
            Function<Notification, Notification> function = (input) -> {
                if (!notificationFilters.get("Spam").test(input)) {
                    return new Notification(input.getType(), input.getMessage().toLowerCase().replaceAll("spam", "NonSP*M"));
                } else {
                    return new Notification(input.getType(), "Новое сообщение, сформированное взамен короткого");
                }
            };
            notificationConsumer.accept(function.apply(notification));
        }
    }

}
