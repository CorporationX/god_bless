package filter_spam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageProcessorTest {
    private MessageProcessor messageProcessor;
    private List<MessageFilter> filters;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        filters = List.of(spamFilter, lengthFilter, emojiFilter);
    }

    @Test
    void processMessage_AllowedMessage_ReturnsTrue() {
        String message = "Long message without emoji";
        boolean isFiltered = messageProcessor.processMessage(message, filters);
        assertTrue(isFiltered);
    }

    @Test
    void processMessage_FilteredMessage_ReturnsFalse() {
        String message = "This is spam!";
        boolean isFiltered = messageProcessor.processMessage(message, filters);
        assertFalse(isFiltered);
    }
}
