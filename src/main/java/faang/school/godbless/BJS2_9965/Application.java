package faang.school.godbless.BJS2_9965;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() <= 15;
        MessageFilter emojiFilter = message -> message.contains("\uD83D\uDE00");
        MessageFilter starFilter = message -> message.contains("*");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, starFilter);
        String[] messages = {"Hello!", "this is spam", "How are you?", "\uD83D\uDE00", "sentence  with two spaces or   even more"};
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("message: " + message + " | missed: " + isFiltered);
        }
    }
}