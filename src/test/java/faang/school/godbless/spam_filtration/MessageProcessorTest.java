package faang.school.godbless.spam_filtration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MessageProcessorTest {
    MessageProcessor messageProcessor;
    private List<MessageFilter> filters;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
    }

    @Test
    void testProcessMessage_shouldThrowExceptionIfArgumentIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> messageProcessor.processMessage("Abc", new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> messageProcessor.processMessage(" ", filters));
    }

    @Test
    void testProcessMessage() {
        String hello = "Привет!";
        String spam = "Это спам!";
        String withSmile = "Как дела? 😀";
        String longSpamMessage = "Длинное сообщение без спама и эмодзи";

        boolean filterHello = messageProcessor.processMessage(hello, filters);
        boolean filterSpam = messageProcessor.processMessage(spam, filters);
        boolean filterSmile = messageProcessor.processMessage(withSmile, filters);
        boolean filterLongSpam = messageProcessor.processMessage(longSpamMessage, filters);

        assertFalse(filterHello);
        assertFalse(filterSmile);
        assertFalse(filterSpam);
        assertFalse(filterLongSpam);
    }
}
