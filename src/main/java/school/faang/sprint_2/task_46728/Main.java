package school.faang.sprint_2.task_46728;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!",
                "This is spam!",
                "How are You? 😀",
                "Long message without ads and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
