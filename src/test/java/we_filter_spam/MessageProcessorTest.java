package we_filter_spam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class MessageProcessorTest {
    private final MessageProcessor MESSAGE_PROCESSOR = new MessageProcessor();

    private final MessageFilter SPAM_FILTER = message -> !message.toLowerCase().contains("спам");
    private final MessageFilter LENGTH_FILTER = message -> message.length() > 10;
    private final MessageFilter EMOJI_FILTER = message -> !message.contains("😀");

    private final List<MessageFilter> FILTERS = Arrays.asList(SPAM_FILTER, LENGTH_FILTER, EMOJI_FILTER);
    private final String[] MESSAGES = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

    @Test
    void processMessage() {
        for (String message : MESSAGES) {
            boolean isFiltered = MESSAGE_PROCESSOR.processMessage(message, FILTERS);
            assertFalse(isFiltered);
        }
    }
}