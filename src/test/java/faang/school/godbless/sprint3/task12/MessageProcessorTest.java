package faang.school.godbless.sprint3.task12;

import faang.school.godbless.sprint3.lambda.task12.MessageFilter;
import faang.school.godbless.sprint3.lambda.task12.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {

    private MessageProcessor messageProcessor;

    @BeforeEach
    void setup() {
        messageProcessor = new MessageProcessor();
    }

    @ParameterizedTest
    @MethodSource("provider")
    void processorMessage(List<MessageFilter> filters, String[] messages) {
        assertFalse(messageProcessor.processMessage(messages[0], filters));
        assertFalse(messageProcessor.processMessage(messages[1], filters));
        assertFalse(messageProcessor.processMessage(messages[2], filters));
        assertFalse(messageProcessor.processMessage(messages[3], filters));
        assertTrue(messageProcessor.processMessage(messages[4], filters));
    }

    @Test
    void testValidationIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> messageProcessor.processMessage(" ", new ArrayList<MessageFilter>()));
    }

    @Test
    void testValidationListMessageFiltersIsNull() {
        assertThrows(IllegalArgumentException.class, () -> messageProcessor.processMessage("hello", null));
    }

    @Test
    void testValidationMessageFiltersIsBlank() {
        List<MessageFilter> messageFilters = new ArrayList<>();
        messageFilters.add(null);
        assertThrows(NullPointerException.class, () -> messageProcessor.processMessage("hello", messageFilters));
    }

    static Stream<Arguments> provider() {
        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи", "Hello world!"};
        return Stream.of(
                Arguments.of(filters, messages)
        );
    }
}