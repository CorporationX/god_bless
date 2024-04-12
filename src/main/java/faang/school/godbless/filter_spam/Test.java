package faang.school.godbless.filter_spam;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> !(message.length() < 15);
        MessageFilter emojiFilter = message -> message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
