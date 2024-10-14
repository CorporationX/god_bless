package ru.kraiush.BJS2_34573;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains(";)");

        List<MessageFilter> filters = List.of(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"This's spam!", "Hi;)", "Good morning everyone! How's it going?", "Ads"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Passed: " + isFiltered);
        }
    }
}
