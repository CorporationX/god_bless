package telegram;

import faang.school.godbless.telegram.MessageFilter;
import faang.school.godbless.telegram.MessageProcessor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageProcessorTest {
  @Test
  public void processMessageTest() {
    MessageProcessor messageProcessor = new MessageProcessor();

    // Создание фильтров
    MessageFilter spamFilter = message -> message.toLowerCase().contains("спам");
    MessageFilter lengthFilter = message -> message.length() > 10;
    MessageFilter emojiFilter = message -> message.contains("😀");

    List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

    Map<String, Boolean> expectedResult = new HashMap<>();
    expectedResult.put("Привет!", false);
    expectedResult.put("Это спам!", true);
    expectedResult.put("Как дела? 😀", true);
    expectedResult.put("Длинное сообщение без спама и эмодзи", true);

    // Обработка сообщений
    String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

    for (String message : messages) {
      boolean isFiltered = messageProcessor.processMessage(message, filters);
      System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);

      assertEquals(expectedResult.get(message), isFiltered);
    }
  }
}
