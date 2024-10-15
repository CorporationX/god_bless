package school.faang.java.lambda.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TranslationManager {
    private final Map<String, Function<Notification, Notification>> notificationConsumerMap = new HashMap<>();

    public void registerTranslatorFunctionMap(String type, Function<Notification, Notification> notificationConsumer) {
        notificationConsumerMap.put(type, notificationConsumer);
    }

    public Notification translateMessage(Notification notification) {
        return notificationConsumerMap.get(notification.getType()).apply(notification);
    }
}