package school.faang.m1s2.bjs2_34700_meta;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
public class NotificationManager {
    private final Map<String, Consumer<Notification>> typeToHandlerMap = new HashMap<>();
    private final Set<String> banWords = new HashSet<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        typeToHandlerMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = typeToHandlerMap.getOrDefault(type, null);
        if (handler == null) {
            throw new RuntimeException("Illegal notification type");
        }
        notification.setMessage(checkBanWords(notification));
        handler.accept(notification);
    }

    private String checkBanWords(Notification notification) {
        String message = notification.getMessage();
        Function<String, String> censor = text -> {
            String censoredText = text;
            for (String word : banWords) {
                if (text.toLowerCase().contains(word)) {
                    censoredText = censoredText.toLowerCase().replace(word, "***");
                }
            }
            return censoredText;
        };
        return censor.apply(message);
    }
}



