package school.faang.spamfilter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Runner {
    public static final Integer MAX_STRING_LENGTH = 10;

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > MAX_STRING_LENGTH;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = List.of(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без SPAM и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            log.info("Сообщение: {} | Прошло все фильтры: {}", message, isFiltered);
        }

    }
}
