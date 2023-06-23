import faang.school.godbless.filteringSpam.MessageFilter;
import faang.school.godbless.filteringSpam.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class MessageProcessorTest {
    MessageProcessor messageProcessor;
    String message;
    List<MessageFilter> messageFilters;
    String[] messages;

    @BeforeEach
    public void init() {
        messageProcessor = new MessageProcessor();

        // Список сообщений
        messages = new String[]{"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам"); // слово или предложение в нижнем регистре не имеет слово "спам"
        MessageFilter lengthFilter = message -> message.length() < 10;
        MessageFilter emojiFilter = message -> !message.contains("😀"); // слово или предложение не содержит смайлика

        messageFilters = Arrays.asList(spamFilter, lengthFilter, emojiFilter); // сохраняем фильтры

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters); // каждому сообщению применяем фильтр
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered); // если сообщение чистое ? true : false
        }
    }
    @Test
    public void messageProcessorTest() {
        // к слово применяем к слову фильтры из списка
        boolean firstFilteredMessage = messageProcessor.processMessage(messages[0], messageFilters);
        boolean secondFilteredMessage = messageProcessor.processMessage(messages[1], messageFilters);
        boolean thirdFilteredMessage = messageProcessor.processMessage(messages[2], messageFilters);
        boolean fourthFilteredMessage = messageProcessor.processMessage(messages[3], messageFilters);
        assertTrue(firstFilteredMessage); // ожидаем что слово "Привет" - чистое
        assertFalse(secondFilteredMessage); // слово "Это спам!" - грязное
        assertFalse(thirdFilteredMessage);
        assertFalse(fourthFilteredMessage);
    }
}
