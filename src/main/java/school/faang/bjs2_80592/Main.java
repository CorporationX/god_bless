package school.faang.bjs2_80592;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {
                "Привет!",
                "Это спам!",
                "Как дела? 😀",
                "Длинное сообщение без спама и эмодзи",
                "Правильное сообщение"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            log.info("Сообщение: {} | Прошло все фильтры: {}", message, isFiltered);
        }
    }
}
