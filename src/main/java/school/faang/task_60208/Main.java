package school.faang.task_60208;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String EMOJI = "😀";
    private static final String SPAM = "spam";
    private static final int MESSAGE_LENGTH = 10;

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains(SPAM);
        MessageFilter lengthFilter = message -> message.length() > MESSAGE_LENGTH;
        MessageFilter emojiFilter = message -> !message.contains(EMOJI);

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!",
                "This is spam!",
                "How are You? 😀",
                "Long message without ads and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.printf("Message: %s | Missed: %s\n", message, isFiltered);
        }
    }
}
