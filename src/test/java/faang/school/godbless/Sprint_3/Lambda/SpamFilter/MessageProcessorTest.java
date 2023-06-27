package faang.school.godbless.Sprint_3.Lambda.SpamFilter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProcessorTest {

    @Test
    public void POSITIVE_processMessageTest () {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String message = "Привет!, все хорошо? Хочу чай :3";

        boolean isFiltered = messageProcessor.processMessage(message, filters);

        assertTrue(isFiltered);
    }
    @Test
    public void NEGATIVE_processMessageTest () {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String message = "Привет!";

        boolean isFiltered = messageProcessor.processMessage(message, filters);

        assertTrue(isFiltered);
    }


}