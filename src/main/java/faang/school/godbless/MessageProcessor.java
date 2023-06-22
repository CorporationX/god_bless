package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(lengthFilter,spamFilter, emojiFilter);

// Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без sпама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        validateMessage(message);
        validateFiltersList(messageFilters);

        boolean isAllowed;
        for (MessageFilter messageFilter : messageFilters) {
            isAllowed = messageFilter.filter(message);
            if (!isAllowed){
                return false;
            }
        }
        return true;
    }

    private void validateMessage(String message) {
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message can't be empty");
        }
    }

    private void validateFiltersList(List<MessageFilter> filtersList){
        if(filtersList.isEmpty()){
            throw new IllegalArgumentException("Filters list can't be empty");
        }
    }
}
