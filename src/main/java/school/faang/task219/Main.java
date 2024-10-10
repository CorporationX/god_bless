package school.faang.task219;

import school.faang.task219.message.MessageFilter;
import school.faang.task219.message.MessageProcessor;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains(" спам ");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        Arrays.stream(messages).toList().forEach(s -> {
            boolean accepted = MessageProcessor.processMessage(s, filters);
            System.out.println("Сообщение: " + s + " | Пропущено: " + accepted);
        });
    }
}
