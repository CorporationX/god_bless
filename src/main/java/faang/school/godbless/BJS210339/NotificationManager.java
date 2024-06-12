package faang.school.godbless.BJS210339;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {

    protected Map<String, Consumer<Notification>> sendHandlers = new HashMap<>();
    protected Map<String, Function<String, String>> mapperHandlers = new HashMap<>();
    protected Map<String, Predicate<String>> filterHandlers = new HashMap<>();


    public void registerHandler(String type, Consumer<Notification> sender) {
        sendHandlers.put(type, sender);
    }

    public void registerHandler(String type, Consumer<Notification> sender, Predicate<String> filter) {
        sendHandlers.put(type, sender);
        filterHandlers.put(type, filter);
    }

    public void registerHandler(String type, Consumer<Notification> sender, Predicate<String> filter, Function<String, String> mapper) {
        sendHandlers.put(type, sender);
        mapperHandlers.put(type, mapper);
        filterHandlers.put(type, filter);
    }

    //TODO:12.06.2024 -  неуверен за реализацю, хотел бы как нибудь максимально от этих if избавиться + хотел бы узнать уместно ли тут применить патерн заместитель?
    public void sendNotification(Notification notification) {
        Notification cloneNotification = notification.clone();
        String type = cloneNotification.getType();

        if (filterHandlers.containsKey(type)) {
            Predicate<String> filter = filterHandlers.get(type);
            String[] messageWords = cloneNotification.getMessage().split(" ");

            for (int i = 0; i < messageWords.length; i++) {
                String messageWord = messageWords[i];

                for (int j = 0; j < messageWord.length(); j++) {
                    String substringMessageWord = messageWord.substring(0, j + 1);

                    if (filter.test(substringMessageWord)) {
                        if (!mapperHandlers.containsKey(type)) {
                            new RuntimeException("Отправка сообщения заблокирована");
                        } else {
                            char lastChar = messageWord.charAt(messageWord.length() - 1);
                            if (!Character.isLetterOrDigit(lastChar)) {
                                messageWord = mapperHandlers.get(type).apply(messageWord.substring(0, messageWord.length() - 1)) + lastChar;
                            }
                            messageWords[i] = mapperHandlers.get(type).apply(messageWord);
                        }
                        break;
                    }

                }

            }

            if (sendHandlers.containsKey(type)) {
                cloneNotification.setMessage(String.join(" ", messageWords));
                sendHandlers.get(type).accept(cloneNotification);
            }

        } else {
            if (sendHandlers.containsKey(type)) {
                sendHandlers.get(type).accept(notification);
            }
        }
    }

}
