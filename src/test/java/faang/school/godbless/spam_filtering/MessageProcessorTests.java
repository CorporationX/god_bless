package faang.school.godbless.spam_filtering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MessageProcessorTests {

    private MessageProcessor messageProcessor;

    private List<MessageFilter> filters;

    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter hardLanguageFilter = message -> !message.toLowerCase().contains("bitch");
        MessageFilter emptyFilter = message -> !message.isEmpty();
        MessageFilter capsFilter = message -> !message.equals(message.toUpperCase());

        filters = List.of(spamFilter, hardLanguageFilter, emptyFilter, capsFilter);
    }

    @Test
    @DisplayName("Filters test")
    void shouldFilterMessages () {
        String spamMessage = "Only today 99% OFF! Seriously, it's not a spam!";
        String hardLanguageMessage = "Miami Bitch is a city in Florida, US";
        String emptyMessage = "";
        String capsMessage = "YOU BETTER PASS THIS TEST";

        Assertions.assertFalse(messageProcessor.processMessage(spamMessage, filters));
        Assertions.assertFalse(messageProcessor.processMessage(hardLanguageMessage, filters));
        Assertions.assertFalse(messageProcessor.processMessage(emptyMessage, filters));
        Assertions.assertFalse(messageProcessor.processMessage(capsMessage, filters));
    }
}
