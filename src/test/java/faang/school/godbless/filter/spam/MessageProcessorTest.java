package faang.school.godbless.filter.spam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {
    MessageProcessor messageProcessor;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();
    }

    @Test
    public void processMessage_CorrectAnswer() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains(":)");
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
        String[] messages = {"Привет!", "Это спам!", "Как дела? :)", "Длинное сообщение без спама и эмодзи"};


        boolean isFiltered1 = messageProcessor.processMessage(messages[0], filters);
        boolean isFiltered2 = messageProcessor.processMessage(messages[1], filters);
        boolean isFiltered3 = messageProcessor.processMessage(messages[2], filters);
        boolean isFiltered4 = messageProcessor.processMessage(messages[3], filters);
        assertFalse(isFiltered1);
        assertFalse(isFiltered2);
        assertFalse(isFiltered3);
        assertFalse(isFiltered4);
    }
}