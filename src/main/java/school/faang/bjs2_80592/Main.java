package school.faang.bjs2_80592;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    private static final MessageFilter SPAM_FILTER = message -> !message.toLowerCase().contains("спам");
    private static final MessageFilter LENGTH_FILTER = message -> message.length() > 10;
    private static final MessageFilter EMOJI_FILTER = message -> !message.contains("😀");

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        List<MessageFilter> filters = Arrays.asList(SPAM_FILTER, LENGTH_FILTER, EMOJI_FILTER);
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
