package faang.school.godbless.SpamFilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MessageProcessorTest {

    MessageProcessor messageProcessor;
    String[] messages;
    List<MessageFilter> filters;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();
        messages = new String[]{"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без эмодзи"};
        filters = new ArrayList<>();
    }

    @Test
    void testFilterMessage() {
        filters.add(message -> !message.toLowerCase().contains("спам"));
        filters.add(message -> message.length() > 10);
        Assertions.assertTrue(messageProcessor.processMessage(messages[2], filters));
        filters.add(message -> !message.contains("😀"));
        Assertions.assertFalse(messageProcessor.processMessage(messages[2], filters));
    }
}