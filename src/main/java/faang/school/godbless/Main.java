package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]){
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() < 10;
        MessageFilter emojiFilter = message -> message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи", "Длинное сообщение", "Привет как дела?"};

        for(String message : messages){
            List<MessageFilter> passedFilters = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Спам: " + !passedFilters.isEmpty());
        }
    }

}
