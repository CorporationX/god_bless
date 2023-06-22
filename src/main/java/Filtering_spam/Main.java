package Filtering_spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter advFilter = message -> !message.contains("реклама");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, advFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀",
                "Длинное сообщение без спама и эмодзи",
                "Сообщение, в котором есть реклама","Сообщение, которое пропустят фильтры"};
        for (String message : messages){
            List<Boolean> filterResults = messageProcessor.processMessage(message,filters);
            for (Boolean result: filterResults){
                System.out.println("Message: " + message
                        + " | Allowed: " + result);
            }
        }

    }
}
