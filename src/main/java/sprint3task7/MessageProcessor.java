package sprint3task7;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    public boolean processMessage (String incomeMessage, List<MessageFilter> objectList) {
        for (MessageFilter x: objectList){
            if(x.filter(incomeMessage)){
                return true;
            } else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter emojiFilter2 = message -> message.contains("Nikita");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, emojiFilter2);

// Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
    }
}}
