package school.faang.task46263;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("=)");

        List<MessageFilter> filters = List.of(spamFilter, lengthFilter, emojiFilter);

        messageProcessor.processMessage("Как твои дела", filters);

        try {
            messageProcessor.processMessage("Хахаха =)", filters);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            messageProcessor.processMessage("Это не спам", filters);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
