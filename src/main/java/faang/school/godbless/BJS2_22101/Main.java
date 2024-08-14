package faang.school.godbless.BJS2_22101;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> !message.isBlank();
        MessageFilter emojiFilter = message -> !message.contains("\uD83D\uDDFF");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
        String[] messages = {"Hello!", "It`s spam", "How are you?\uD83D\uDDFF", "Long message without _ and emoji"};
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | isFiltered: " + isFiltered);
        }
    }
}
