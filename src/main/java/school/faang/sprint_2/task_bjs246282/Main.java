package school.faang.sprint_2.task_bjs246282;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter adsFilter = message -> !message.toLowerCase().contains("реклама");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        Set<MessageFilter> filters = Set.of(spamFilter, adsFilter, lengthFilter, emojiFilter);

        List<String> messages = List.of(
                "Привет!",
                "Это спам!",
                "Это реклама! КУПИ СЛОНА!",
                "Как дела? 😀",
                "Хорошее длинное сообщение",
                "Тоже хорошее длинное сообщение"
        );

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
