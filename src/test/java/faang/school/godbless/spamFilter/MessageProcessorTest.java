package faang.school.godbless.spamFilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageProcessorTest {
    private MessageProcessor messageProcessor;
    private MessageFilter spamFilter;
    private MessageFilter lengthFilter;
    private MessageFilter emojiFilter;
    private List<MessageFilter> filters;

    @BeforeEach
    void setUp(){
        messageProcessor = new MessageProcessor();
        spamFilter = message -> message.toLowerCase().contains("спам");
        lengthFilter = message -> message.length() < 10;
        emojiFilter = message -> message.contains("\\uD83D\\uDE00");
        filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);
    }

    @ParameterizedTest
    @MethodSource("prepareData")
    void testProcessMessage(String message, boolean expected) {
        assertEquals(expected, messageProcessor.processMessage(message, filters));
    }

    static Stream<Arguments> prepareData(){
        return Stream.of(
                Arguments.of("Привет!", true),
                Arguments.of("Это спам!", true),
                Arguments.of("Как ты? \\uD83D\\uDE00", true),
                Arguments.of("Длинное сообщение без спама и эмоджи", true),
                Arguments.of("Длинное которое должно пройти фильтры.", false)
        );
    }
}