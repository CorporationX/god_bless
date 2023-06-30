package god_bless.godbless.sprint3task7;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String incomeMessage, List<MessageFilter> objectList) {
        for (MessageFilter oneFilter : objectList) {
            if (!oneFilter.filter(incomeMessage)) {
                return false;
            }
        }
        return true;
//если сообщение удовлетворяет всем фильтрам, то список фильтров доходит до конца, так и не провалившись в return false;,
//зато она доходит до конца и просто возвращает true;.
    }
//цикл проверяет каждый фильтр из списка objectList для пришедшего сообщения incomeMessage.
//Если хотя бы один фильтр не проходит (oneFilter.filter(incomeMessage)) = false, то проваливаемся в return false;.
//Если все фильтры успешно проходят, то есть каждый с каждым фильтром (oneFilter.filter(incomeMessage)) = true, то
//не проваливаемся return false; после if, а проваливаемся в return true; после выполнения всех фильтров для сообщения.

//как только вывелось return false; для какого то фильтра, то цикл для этого сообщения заканчивается, тк прозвучало return;.
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("");
        MessageFilter emojiFilter2 = message -> message.contains("N");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, emojiFilter2);

// Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? ", "Длинное сообщение без спама и эмодзи", "NNNNNNNNNNNN"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
