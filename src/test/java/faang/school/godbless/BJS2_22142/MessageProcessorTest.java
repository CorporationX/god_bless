package faang.school.godbless.BJS2_22142;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class MessageProcessorTest {
    private final ByteArrayOutputStream OUTPUT_CAPTOR = new ByteArrayOutputStream();
    private static final PrintStream ORIGINAL_OUTPUT = System.out;
    private MessageProcessor messageProcessor;
    private MessageFilter spamFilter;
    private MessageFilter lengthFilter;
    private MessageFilter emojiFilter;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(OUTPUT_CAPTOR));
        messageProcessor = new MessageProcessor();
        spamFilter = message -> !message.toLowerCase().contains("спам");
        lengthFilter = message -> message.length() > 10;
        emojiFilter = message -> !message.contains("😀");
    }

    @Test
    void processMessage() {
        List<MessageFilter> filters = new ArrayList<>(List.of(spamFilter, lengthFilter, emojiFilter));
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи",
                "Таким образом, семантический разбор внешних противодействий, а также свежий взгляд на привычные вещи."};
        String expectedOutput = """
                Сообщение: Привет! | Отфильтровано: false
                Сообщение: Это спам! | Отфильтровано: false
                Сообщение: Как дела? 😀 | Отфильтровано: false
                Сообщение: Длинное сообщение без спама и эмодзи | Отфильтровано: false
                Сообщение: Таким образом, семантический разбор внешних противодействий, а также свежий взгляд на привычные вещи. | Отфильтровано: true
                """;

        for (var message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Отфильтровано: " + isFiltered);
        }

        Assertions.assertThat(normalize(OUTPUT_CAPTOR.toString())).isEqualTo(expectedOutput);
        System.setOut(ORIGINAL_OUTPUT);
        System.out.println(OUTPUT_CAPTOR);
    }

    private String normalize(String input) {
        return input.replaceAll("\\r+", "");
    }
}