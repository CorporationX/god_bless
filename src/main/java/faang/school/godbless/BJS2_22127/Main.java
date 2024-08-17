package faang.school.godbless.BJS2_22127;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter emojiFilter = message -> !message.contains("\uD83D\uDE00");
        List<MessageFilter> filters = Arrays.asList(spamFilter, emojiFilter);
        String[] messages = {"Hello!", "This is spam!", "How are you? \uD83D\uDE00"};
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Accepted: " + isFiltered);
        }
    }
}
