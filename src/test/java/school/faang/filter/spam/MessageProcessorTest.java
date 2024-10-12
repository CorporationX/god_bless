package school.faang.filter.spam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageProcessorTest {
    private List<String> filteredMessages;

    MessageFilter spamFilter;
    MessageFilter lengthFilter;
    MessageFilter emojiFilter;
    List<MessageFilter> filters;

    @BeforeEach
    public void setUp() {
        filteredMessages = new ArrayList<>();

        spamFilter = message -> !message.toLowerCase().contains("спам");
        lengthFilter = message -> message.length() > 10;
        emojiFilter = message -> !message.contains("😀");
        filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
    }

    @Test
    public void addWordToDictionaryTest() {
        String[] messages = {
                "Привет!",
                "Это спам!",
                "Как дела? 😀",
                "Длинное, валидное сообщение"};
        List<String> expected = List.of("Длинное, валидное сообщение");

        Arrays.stream(messages)
                .peek(message -> {
                    boolean isFiltered = MessageProcessor.processMessage(message, filters);
                    System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
                })
                .filter(message -> MessageProcessor.processMessage(message, filters))
                .forEach(message -> filteredMessages.add(message));

        assertEquals(expected, filteredMessages);
        assertEquals(expected.size(), filteredMessages.size());
    }
}
