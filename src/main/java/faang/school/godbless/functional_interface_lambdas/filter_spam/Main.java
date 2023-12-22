package faang.school.godbless.functional_interface_lambdas.filter_spam;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = msg -> !msg.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> !(message.length() > 10);
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = List.of(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }

    }
}


@FunctionalInterface
interface MessageFilter {
    boolean filter(String msg);
}

class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}