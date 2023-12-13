package faang.school.godbless.filter_spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("\uD83D\uDE00");
        MessageFilter marketing = message -> message.toLowerCase().contains("marketing");
        MessageFilter privat = message -> message.toLowerCase().contains("private");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, marketing, privat);

        String[] messages = {"Привет!", "Это спам!", "Как дела? \uD83D\uDE00", "Длинные сообщения без спама и эмодзи"
                , "marketing shop", "privat chat", "java"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.ProcessMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}


class MessageProcessor {
    public boolean ProcessMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                System.out.println("Сообщение не прошло фильтрацию: " + message);
                return false;
            }
        }
        return true;
    }
}