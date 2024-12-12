package school.faang.task_46277;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String SPAM = "spam";
    private static final int MIN_LENGTH = 10;
    private static final String EMOJI = ";)";

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains(SPAM);
        MessageFilter lengthFilter = message -> message.length() > MIN_LENGTH;
        MessageFilter emojiFilter = message -> !message.contains(EMOJI);

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!",
                "This is spam!",
                "How are you? ;)",
                "Long message without and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.printf("Сообщение: %s | Пропущено: %s%n", message, isFiltered);
        }
    }
}
