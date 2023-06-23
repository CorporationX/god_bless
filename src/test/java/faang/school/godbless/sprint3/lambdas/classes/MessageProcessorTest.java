package faang.school.godbless.sprint3.lambdas.classes;

import faang.school.godbless.sprint3.lambdas.filterSpam.classes.MessageProcessor;
import faang.school.godbless.sprint3.lambdas.filterSpam.interfaces.MessageFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MessageProcessorTest {

    private static List<MessageFilter> filters;
    private static MessageProcessor messageProcessor;

    private static final MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
    private static final MessageFilter lengthFilter = message -> message.length() <= 15;
    private static final MessageFilter profanityFiler = message -> !message.toLowerCase().contains("fuck");

    @BeforeAll
    static void setUp() {
        messageProcessor = new MessageProcessor();
        filters = List.of(spamFilter, lengthFilter, profanityFiler);
    }

    @ParameterizedTest
    @MethodSource("getMessage")
    @DisplayName("Filter test")
    void processMessage_filterTest(boolean expected, String message) {
        boolean result = messageProcessor.processMessage(message, filters);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("getIncorrectWord")
    @DisplayName("Null or empty word")
    void processMessage_NullWordTest(String word) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> messageProcessor.processMessage(word, filters));
        assertEquals(MessageProcessor.MESSAGE_IS_NULL_OR_EMPTY, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getIncorrectFilters")
    @DisplayName("Null or empty filters")
    void processMessage_NullFiltersTest(List<MessageFilter> filters) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> messageProcessor.processMessage("message", filters));
        assertEquals(MessageProcessor.FILTERS_LIST_IS_NULL_OR_EMPTY, exception.getMessage());
    }

    private static Stream<Arguments> getIncorrectWord() {
        String nulLString = null;
        String emptyString = "";
        return Stream.of(
                Arguments.of(nulLString),
                Arguments.of(emptyString)
        );
    }

    private static Stream<Arguments> getIncorrectFilters() {
        List<MessageFilter> nullList = null;
        return Stream.of(
                Arguments.of(nullList),
                Arguments.of(new ArrayList<MessageFilter>())
        );
    }

    private static Stream<Arguments> getMessage() {
        return Stream.of(
                Arguments.of(true, "Just message"),
                Arguments.of(false, "FUCK YOU"),
                Arguments.of(false, "spam message"),
                Arguments.of(false, "Enormous message, contains more than 15 symbols"),
                Arguments.of(true, "One more msg")
        );
    }
}