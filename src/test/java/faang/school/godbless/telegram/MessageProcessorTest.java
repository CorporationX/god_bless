package faang.school.godbless.telegram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MessageProcessorTest {

    private MessageProcessor messageProcessor;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();
    }

    @Test
    void messageProcessorTest() {
        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        boolean[] expected = {true, false, true, false};
        for (int i = 0; i < messages.length; i++) {
            String message = messages[i];
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            assertEquals(expected[i], isFiltered,
                "Сообщение: " + messages[i] + " | Пропущено: " + expected[i] + " | Actual: " + isFiltered);
        }
    }

    @Test
    void processMessageWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () ->
            messageProcessor.processMessage(null, Collections.emptyList()));
    }
}