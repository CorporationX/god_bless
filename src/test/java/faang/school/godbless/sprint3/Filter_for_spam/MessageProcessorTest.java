package faang.school.godbless.sprint3.Filter_for_spam;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {
    MessageProcessor messageProcessor = new MessageProcessor();

    @Test
    void test_processMessageSpamFilter() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        List list = List.of(spamFilter);
        assertTrue(messageProcessor.processMessage("Подходит под тест", list));
        assertFalse(messageProcessor.processMessage("спам", list));
    }

    @Test
    void test_processMessageLengthFilter() {
        MessageFilter lengthFilter = message -> message.length() > 10;
        List list = List.of(lengthFilter);
        assertTrue(messageProcessor.processMessage("Подходит под тест", list));
        assertFalse(messageProcessor.processMessage("нет", list));
    }

    @Test
    void test_processMessageEmojiFilter() {
        MessageFilter emojiFilter = message -> !message.contains("😀");
        List list = List.of(emojiFilter);
        assertTrue(messageProcessor.processMessage("Подходит под тест", list));
        assertFalse(messageProcessor.processMessage("нет-😀", list));
    }
}