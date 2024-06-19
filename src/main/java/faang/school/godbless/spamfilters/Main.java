package faang.school.godbless.spamfilters;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int MIN_LENGTH_MESSAGE = 15;

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > MIN_LENGTH_MESSAGE;
        MessageFilter emojiFilter = message -> message.contains(":)");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!", "this is spam!", "What's up? :)", "Long message without spm and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Skipped: " + isFiltered);
        }
    }
}
