package faang.school.godbless.spam_filters;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter<String>> messageFilterList){
        boolean isValid = true;
        for (MessageFilter<String> filter : messageFilterList){
            if(!filter.filter(message)){
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    public static void main(String[] args) {

        MessageFilter<String> spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter<String> lengthFilter = message -> message.length() > 5;
        MessageFilter<String> emojiFilter = message -> !message.contains("\uD83D\uDE00");
        List<MessageFilter<String>> filters = List.of(spamFilter, lengthFilter, emojiFilter);
        MessageProcessor messageProcessor = new MessageProcessor();

        String[] messages = {"There's spam here", "msg", "Как дела? 😀", "Valid message here"};

        for (String message : messages){
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
