package faang.school.godbless.sprint3.spam;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageProcessorTest {
    private MessageProcessor messageProcessor;
    private List<MessageFilter> filters;


    @BeforeEach
    void setUp() {
        messageProcessor = new MessageProcessor();
        filters = List.of(
                message -> !message.toLowerCase().contains("спам"),
                message -> message.length() > 10,
                message -> !message.contains("😀")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void processMessage(String message, boolean expected) {
        boolean isFiltered = messageProcessor.processMessage(message, filters);
        System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        assertEquals(expected, isFiltered);
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("Привет!", false),
                Arguments.of("Это спам!", false),
                Arguments.of("Как дела? 😀", false),
                Arguments.of("Длинное сообщение без спама и эмодзи", false),
                Arguments.of("FAANG-SCHOOL", true)
        );
    }
}