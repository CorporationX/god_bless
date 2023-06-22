import faang.school.godbless.filteringSpam.MessageFilter;
import faang.school.godbless.filteringSpam.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class MessageProcessorTest {
    MessageProcessor messageProcessor;
    String message;
    List<MessageFilter> messageFilters;
    String[] messages;

    @BeforeEach
    public void init() {
        messageProcessor = new MessageProcessor();

        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        messageFilters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Обработка сообщений
        messages = new String[]{"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
    @Test
    public void messageProcessorTest() {
        boolean firstFilteredMessage = messageProcessor.processMessage(messages[0], messageFilters);
        boolean secondFilteredMessage = messageProcessor.processMessage(messages[1], messageFilters);
        boolean thirdFilteredMessage = messageProcessor.processMessage(messages[2], messageFilters);
        boolean fourthFilteredMessage = messageProcessor.processMessage(messages[3], messageFilters);
        assertFalse(firstFilteredMessage);
        assertFalse(secondFilteredMessage);
        assertFalse(thirdFilteredMessage);
        assertFalse(fourthFilteredMessage);
    }
}
