package school.faang.m1s2.bjs2_34700_meta;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;

@Data
public class NotificationManager {
    private final static Map<String, Set<String>> MESSAGE_FILTERS = new HashMap<>();
    private final static BiFunction<String, Set<String>, String> CENSOR = (text, filter) -> {
        String censoredText = text;
        for (String word : filter) {
            if (text.toLowerCase().contains(word)) {
                censoredText = censoredText.toLowerCase().replace(word, "***");
            }
        }
        return censoredText;
    };

    private final Map<String, Consumer<Notification>> typeToHandlerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        typeToHandlerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = typeToHandlerMap.getOrDefault(type, null);
        if (handler == null) {
            throw new RuntimeException("Illegal notification type");
        }
    }

    public void sendNotification(Notification notification, String filterName) {
        String type = notification.getType();
        Consumer<Notification> handler = typeToHandlerMap.getOrDefault(type, null);
        if (handler == null) {
            throw new RuntimeException("Illegal notification type");
        }
        Set<String> filter = assignFilter(filterName);
        notification.setMessage(checkBanWords(notification, filter));
        handler.accept(notification);
    }

    public void addFilter(String filterName, Set<String> filterWords) {
        MESSAGE_FILTERS.put(filterName, filterWords);
    }

    private String checkBanWords(Notification notification, Set<String> filter) {
        String message = notification.getMessage();
        return CENSOR.apply(message, filter);
    }

    private Set<String> assignFilter(String filtername) {
        if (!MESSAGE_FILTERS.containsKey(filtername)) {
            throw new IllegalArgumentException("Invalid filter");
        }
        return MESSAGE_FILTERS.get(filtername);
    }
}



