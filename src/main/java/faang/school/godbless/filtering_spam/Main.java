package faang.school.godbless.filtering_spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();

        MessageFilter spamFilter = message -> message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> (message.length() > 14);
        MessageFilter emojiFilter = message -> message.contains("?");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? ?", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = processor.processorMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
