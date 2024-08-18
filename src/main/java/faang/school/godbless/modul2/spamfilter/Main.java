package faang.school.godbless.modul2.spamfilter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!", "This is spam!", "How are you? 😀", "Long message without spam and emojis", "SPAM 😀 SPAM 😀 SPAM "};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Skipped: " + isFiltered);
        }
    }
}
