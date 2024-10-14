package Sprint_2.BJS2_34610;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        // Фильтры
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam"); // блокирует спам
        MessageFilter lengthFilter = message -> message.length() <= 10; // блокирует короткие сообщения
        MessageFilter emojiFilter = message -> !message.contains("emoji"); // блокирует эмодзи

        // Список фильтров
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Входящие сообщения
        String[] messages = {
                "Hello!",  // длина меньше 10 символов
                "This spam!", // содержит слово "спам"
                "How are you? эмодзи", // содержит "эмодзи"
                "Long message without spam and emoji" // проходит все фильтры
        };

        // Обработка сообщений
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
