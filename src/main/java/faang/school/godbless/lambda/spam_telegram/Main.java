package faang.school.godbless.lambda.spam_telegram;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter lengthFilter = x -> x.length() > 5;
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи", "Привет! Поедешь в Москву?"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
