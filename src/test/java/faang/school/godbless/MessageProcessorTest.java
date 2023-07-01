package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageProcessorTest {
    MessageProcessor messageProcessor;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();
    }

    @Test
    void testFilterMessages() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() < 100;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        assertFalse(messageProcessor.processMessage("Привет😀!", filters));
        assertFalse(messageProcessor.processMessage("Привет спам!", filters));
        assertTrue(messageProcessor.processMessage("Привет!", filters));
    }

    @Test
    void testEmptyMessage() {
        MessageFilter lengthFilter = message -> !message.isBlank();
        List<MessageFilter> filters = List.of(lengthFilter);

        assertTrue(messageProcessor.processMessage("Привет😀!", filters));
        assertFalse(messageProcessor.processMessage("  ", filters));
        assertFalse(messageProcessor.processMessage("", filters));
    }
}